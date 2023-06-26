package ru.itconsulting.tech.rest.model.crud;

import lombok.Data;
import ru.itconsulting.tech.dao.entity.NomenclatureEntity;
import ru.itconsulting.tech.dao.entity.StationPathEntity;
import ru.itconsulting.tech.dao.entity.WagonPassportEntity;

import javax.persistence.ManyToOne;

@Data
public class WagonCrudModel {
    private Long id;
    private WagonPassportCrudModel wagonPassportCrudModel;
    private String wagonNumber;
    private NomenclatureCrudModel nomenclatureCrudModel;
    private Double nomenclatureWeight;
    private Double wagonWeight;
    private Integer orderNum;
    private StationPathCrudModel stationPathCrudModel;
}
