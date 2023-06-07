package ru.itconsulting.tech.dao.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class WagonPassport {
    @Id
    private Long id;
    private WagonTypeEnum type;
    private String number;
    private Double weight;
    private Double capacity;

}
