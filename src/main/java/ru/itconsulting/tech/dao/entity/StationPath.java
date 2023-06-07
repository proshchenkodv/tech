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
public class StationPath {
    @Id
    private Long id;
    private String pathName;
    @ManyToOne(fetch = FetchType.LAZY)
    private Station  station;
}
