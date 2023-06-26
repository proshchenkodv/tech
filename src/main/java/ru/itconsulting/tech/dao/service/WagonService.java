package ru.itconsulting.tech.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itconsulting.tech.dao.entity.WagonEntity;
import ru.itconsulting.tech.dao.repository.WagonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WagonService {
    @Autowired
    private WagonRepository wagonRepository;

    public WagonEntity save(WagonEntity wagon) {
        return wagonRepository.save(wagon);
    }

    public WagonEntity findById(Long id) {
        Optional<WagonEntity> wagon = wagonRepository.findById(id);
        return wagon.orElse(null);
    }

    public List<WagonEntity> findAll() {
        return wagonRepository.findAll();
    }

    public void deleteById(Long id) {
        wagonRepository.deleteById(id);
    }
}
