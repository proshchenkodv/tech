package ru.itconsulting.tech.dao.entity;

import com.sun.javafx.beans.IDProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@ToString
@EqualsAndHashCode
@Table
public class Station {
    @Id
    private Long id;
    private String stationName;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "station")
    private List<StationPath> pathList;
}
