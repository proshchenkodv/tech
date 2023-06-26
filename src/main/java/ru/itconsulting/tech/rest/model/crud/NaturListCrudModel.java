package ru.itconsulting.tech.rest.model.crud;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NaturListCrudModel {
    private String naturListName;
    private List<WagonCrudModel> wagonEntityList;
}
