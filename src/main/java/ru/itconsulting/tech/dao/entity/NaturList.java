package ru.itconsulting.tech.dao.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class NaturList {
    @Id
    private Long id;
    @OneToMany
    private List<Wagon> wagonList;
}
