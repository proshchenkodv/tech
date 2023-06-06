package ru.itconsulting.tech.rest.controllers;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
public class MainRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainRestController.class);

    @Operation(summary = "Тест переменные окружения")
    @RequestMapping(value = "/test/env", method = RequestMethod.GET, produces = "text/plain")
    public String testEnv() {
        StringBuilder sb = new StringBuilder();
        for (String key : System.getenv().keySet()) {
            sb.append(key).append(":").append(System.getenv().get(key)).append("\r\n");
        }
        return sb.toString();
    }

    @Operation(summary = "Тест эхо")
    @RequestMapping(value = "/test/echo/{message}", method = RequestMethod.GET, produces = "text/plain")
    public String testEcho(@PathVariable("message") String message) {
        return message;
    }

    @Operation(summary = "Тест авторизации")
    @RequestMapping(value = "/test/auth", method = RequestMethod.GET, produces = "text/plain")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    public String testAuth() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return "test with auth passed for user: " + ((UserDetailsImpl) auth.getPrincipal()).getUsername();
    }
}