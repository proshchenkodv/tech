package ru.itconsulting.tech.rest.controllers;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.itconsulting.tech.rest.security.services.UserDetailsImpl;


@Hidden
@Tag(name = "Основные операции")
@RestController
@RequestMapping(value = "/api", produces = "application/json;charset=utf-8")
@Slf4j
public class MainRestController {

    @Operation(summary = "Тест авторизации")
    @RequestMapping(value = "/test/auth", method = RequestMethod.GET, produces = "text/plain")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    public String testAuth() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return "test with auth passed for user: " + ((UserDetailsImpl) auth.getPrincipal()).getUsername();
    }
}