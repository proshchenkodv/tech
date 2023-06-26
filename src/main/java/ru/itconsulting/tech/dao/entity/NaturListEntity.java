package ru.itconsulting.tech.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "NATUR_LIST", schema = "tech")
public class NaturListEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String naturlistName;
    @OneToMany
    @OrderBy("orderNum")
    @JoinTable(name = "NATUR_LIST_WAGON", schema = "tech",
            joinColumns = @JoinColumn(name = "NATUR_LIST_ID"), inverseJoinColumns = @JoinColumn(name = "WAGON_ID"))
    private List<WagonEntity> wagonEntityList;
}
