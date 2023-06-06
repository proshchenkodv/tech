package ru.itconsulting.tech.rest.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itconsulting.tech.rest.model.Role;
import ru.itconsulting.tech.rest.model.RoleEnum;
import ru.itconsulting.tech.rest.model.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    //@Autowired
    //UserRepository userRepository;

    @Autowired
    private Environment env;

    @Override
    //@Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User user = new User(env.getProperty("rest.api.user"), "", encoder.encode(env.getProperty("rest.api.password")));
        user.getRoles().add(new Role(1, RoleEnum.valueOf(env.getProperty("rest.api.roles"))));
        return UserDetailsImpl.build(user);
    }

}