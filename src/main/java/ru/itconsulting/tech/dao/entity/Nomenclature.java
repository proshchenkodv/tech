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
@Table(name = "NOMENCLATURE", schema = "tech")
public class Nomenclature {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomenclatureCode;
    private String nomenclatureName;
}
