package ru.itconsulting.tech.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itconsulting.tech.dao.entity.NaturListEntity;
import ru.itconsulting.tech.dao.service.NaturListService;
import ru.itconsulting.tech.rest.model.crud.NaturListCrudModel;

@Service
public class NaturListRestService {
    @Autowired
    private NaturListService naturListService;

    public NaturListEntity createNaturList(NaturListCrudModel model) {
        return naturListService.createNaturList(model);
    }
}
