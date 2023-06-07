package ru.itconsulting.tech.dao.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "STATION_PATH", schema = "tech")
public class StationPath {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String pathName;
    @ManyToOne
    private Station  station;
}
