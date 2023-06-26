package ru.itconsulting.tech.dao.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "NOMENCLATURE", schema = "tech")
public class NomenclatureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomenclatureCode;
    private String nomenclatureName;
}



    /*напиши сервисный уровень сущности
    используя JPARepository*/