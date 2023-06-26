package ru.itconsulting.tech.rest.controllers.crud;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Контроллер crud операций номенклатур")
@RestController
@RequestMapping(value = "/api/nomenclature/crud", produces = "application/json;charset=utf-8")
@Slf4j
public class NomenclatureCrudController {
}
