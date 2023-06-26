package ru.itconsulting.tech.dao.entity;

import lombok.*;
import ru.itconsulting.tech.enums.WagonTypeEnum;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "WAGON_PASSPORT", schema = "tech")
public class WagonPassportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    private WagonTypeEnum type;
    private String number;
    private Double weight;
    private Double capacity;
}
