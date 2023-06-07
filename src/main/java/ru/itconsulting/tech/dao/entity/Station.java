package ru.itconsulting.tech.dao.entity;

import com.sun.javafx.beans.IDProperty;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "STATION", schema = "tech")
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String stationName;
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "station")
//    private List<StationPath> pathList;
}
