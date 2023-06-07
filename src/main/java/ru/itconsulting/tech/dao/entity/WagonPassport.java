package ru.itconsulting.tech.dao.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.itconsulting.tech.enums.WagonTypeEnum;

import javax.persistence.*;

@Entity
@Setter
@Getter
@ToString
@EqualsAndHashCode
@Table
public class WagonPassport {
    @Id
    private Long id;
    @Enumerated(EnumType.STRING)
    private WagonTypeEnum type;
    private String number;
    private Double weight;
    private Double capacity;
}
