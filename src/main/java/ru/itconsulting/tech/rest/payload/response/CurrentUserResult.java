package ru.itconsulting.tech.rest.payload.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CurrentUserResult {
    private String principal;
    private Set<String> roles;
}
