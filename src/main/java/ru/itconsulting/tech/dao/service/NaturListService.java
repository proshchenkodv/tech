package ru.itconsulting.tech.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itconsulting.tech.dao.entity.NaturListEntity;
import ru.itconsulting.tech.dao.repository.NaturListRepository;
import ru.itconsulting.tech.rest.model.crud.NaturListCrudModel;

import java.util.List;
import java.util.Optional;

@Service
public class NaturListService {
    @Autowired
    private NaturListRepository naturListRepository;

    public NaturListEntity save(NaturListEntity naturList) {
        return naturListRepository.save(naturList);
    }

    public NaturListEntity findById(Long id) {
        Optional<NaturListEntity> naturList = naturListRepository.findById(id);
        return naturList.orElse(null);
    }

    public List<NaturListEntity> findAll() {
        return naturListRepository.findAll();
    }

    public void deleteById(Long id) {
        naturListRepository.deleteById(id);
    }
}
