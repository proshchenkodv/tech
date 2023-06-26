package ru.itconsulting.tech.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itconsulting.tech.dao.entity.NomenclatureEntity;
import ru.itconsulting.tech.dao.repository.NomenclatureRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NomenclatureService {

    @Autowired
    private NomenclatureRepository nomenclatureRepository;

    public List<NomenclatureEntity> getAllNomenclatures() {
        return nomenclatureRepository.findAll();
    }

    public Optional<NomenclatureEntity> getNomenclatureById(Long id) {
        return nomenclatureRepository.findById(id);
    }

    public NomenclatureEntity saveNomenclature(NomenclatureEntity nomenclature) {
        return nomenclatureRepository.save(nomenclature);
    }

    public void deleteNomenclature(Long id) {
        nomenclatureRepository.deleteById(id);
    }
}
