package ru.itconsulting.tech.dao.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "user", schema = "tech")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles", schema = "tech", catalog = "postgres", joinColumns =
            {
                    @JoinColumn(name = "user_id", nullable = false, updatable = false)
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "role_id", nullable = false, updatable = false)
            }
    )
    private List<RoleEntity> roles;
}
