package ru.itconsulting.tech.rest.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ru.itconsulting.tech.rest.payload.request.LoginRequest;
import ru.itconsulting.tech.rest.payload.response.CurrentUserResult;
import ru.itconsulting.tech.rest.payload.response.JwtResponse;
import ru.itconsulting.tech.rest.security.jwt.JwtUtils;
import ru.itconsulting.tech.rest.security.services.UserDetailsImpl;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Авторизация")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
    public ResponseEntity<JwtResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }

    @GetMapping(value = "/user")
    public ResponseEntity<CurrentUserResult> getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CurrentUserResult cur = new CurrentUserResult();
        if (auth instanceof UsernamePasswordAuthenticationToken) {
            UserDetails userDetails = (UserDetails) auth.getPrincipal();
            cur.setPrincipal(userDetails.getUsername());
            cur.setRoles(userDetails.getAuthorities().stream().map(o -> o.getAuthority()).collect(Collectors.toSet()));
        } else if (auth instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) auth.getPrincipal();
            cur.setPrincipal(userDetails.getUsername());
            cur.setRoles(userDetails.getAuthorities().stream().map(o -> o.getAuthority()).collect(Collectors.toSet()));
        } else if (auth instanceof AnonymousAuthenticationToken) {
            AnonymousAuthenticationToken userDetails = (AnonymousAuthenticationToken) auth;
            cur.setPrincipal(userDetails.getName());
            cur.setRoles(userDetails.getAuthorities().stream().map(o -> o.getAuthority()).collect(Collectors.toSet()));
        } else {
            cur.setPrincipal("anonymousUser");
            cur.setRoles(new HashSet<>(Collections.singletonList("ROLE_ANONYMOUS")));
        }
        return ResponseEntity.ok(cur);
    }

}