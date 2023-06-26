package ru.itconsulting.tech.rest.controllers.crud;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.itconsulting.tech.rest.model.crud.NaturListCrudModel;
import ru.itconsulting.tech.rest.security.services.UserDetailsImpl;

@Tag(name = "Контроллер crud операций натур листав")
@RestController
@RequestMapping(value = "/api/naturList/crud", produces = "application/json;charset=utf-8")
@Slf4j
public class NaturListCrudController {

    @Operation(summary = "Тест авторизации")
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    public String createNaturList(NaturListCrudModel model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return "test with auth passed for user: " + ((UserDetailsImpl) auth.getPrincipal()).getUsername();
    }
}
