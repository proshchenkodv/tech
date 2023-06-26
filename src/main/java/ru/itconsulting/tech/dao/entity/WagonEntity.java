package ru.itconsulting.tech.dao.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "WAGON", schema = "tech")
public class WagonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private WagonPassportEntity wagonPassportEntity;
    private String wagonNumber;
    @ManyToOne
    private NomenclatureEntity nomenclatureEntity;
    private Double nomenclatureWeight;
    private Double wagonWeight;
    private Integer orderNum;
    @ManyToOne
    private StationPathEntity stationPathEntity;
}
