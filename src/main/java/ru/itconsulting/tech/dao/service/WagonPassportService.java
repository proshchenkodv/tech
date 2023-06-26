package ru.itconsulting.tech.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itconsulting.tech.dao.entity.WagonPassportEntity;
import ru.itconsulting.tech.dao.repository.WagonPassportRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WagonPassportService {
    @Autowired
    private WagonPassportRepository wagonPassportRepository;

    public WagonPassportEntity save(WagonPassportEntity wagonPassport) {
        return wagonPassportRepository.save(wagonPassport);
    }

    public WagonPassportEntity findById(Long id) {
        Optional<WagonPassportEntity> wagonPassport = wagonPassportRepository.findById(id);
        return wagonPassport.orElse(null);
    }

    public List<WagonPassportEntity> findAll() {
        return wagonPassportRepository.findAll();
    }

    public void deleteById(Long id) {
        wagonPassportRepository.deleteById(id);
    }
}
