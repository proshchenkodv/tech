package ru.itconsulting.tech.rest.model;

public class Role {
    private Integer id;

    private RoleEnum name;

    public Role() {

    }

    public Role(Integer id, RoleEnum name) {
        this.id = id;
        this.name = name;
    }

    public Role(RoleEnum name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RoleEnum getName() {
        return name;
    }

    public void setName(RoleEnum name) {
        this.name = name;
    }
}