package ru.itconsulting.tech.dao.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Setter
@Getter
@ToString
@EqualsAndHashCode
@Table
public class Wagon {
    @Id
    private Long id;
    @ManyToOne
    private WagonPassport wagonPassport;
    private String wagonNumber;
    @ManyToOne
    private Nomenclature nomenclature;
    private Double nomenclatureWeight;
    private Double wagonWeight;
}
