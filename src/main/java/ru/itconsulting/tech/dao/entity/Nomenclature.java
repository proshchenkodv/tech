package ru.itconsulting.tech.dao.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@ToString
@EqualsAndHashCode
@Table
public class Nomenclature {
    @Id
    private Long id;
    private String nomenclatureCode;
    private String nomenclatureName;
}
