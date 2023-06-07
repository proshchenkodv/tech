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
@Table(name = "WAGON", schema = "tech")
public class Wagon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private WagonPassport wagonPassport;
    private String wagonNumber;
    @ManyToOne
    private Nomenclature nomenclature;
    private Double nomenclatureWeight;
    private Double wagonWeight;
}
