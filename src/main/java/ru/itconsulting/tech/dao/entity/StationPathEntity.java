package ru.itconsulting.tech.dao.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "STATION_PATH", schema = "tech")
public class StationPathEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String pathName;
    @ManyToOne
    @JoinColumn(name = "STATION_ID")
    private StationEntity stationEntity;
}
