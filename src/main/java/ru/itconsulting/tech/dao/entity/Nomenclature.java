package ru.itconsulting.tech.dao.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Nomenclature {
    @Id
    private Long id;
    private String nomenclatureCode;
    private String nomenclatureName;
}
