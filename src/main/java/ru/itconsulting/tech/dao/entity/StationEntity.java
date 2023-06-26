package ru.itconsulting.tech.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "STATION", schema = "tech")
public class StationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String stationName;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "station")
    private List<StationPathEntity> pathList;
}
