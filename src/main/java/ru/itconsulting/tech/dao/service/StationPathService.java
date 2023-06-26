package ru.itconsulting.tech.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itconsulting.tech.dao.entity.StationPathEntity;
import ru.itconsulting.tech.dao.repository.StationPathRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StationPathService {

    @Autowired
    private StationPathRepository stationPathRepository;

    public List<StationPathEntity> getAllStationPaths() {
        return stationPathRepository.findAll();
    }

    public Optional<StationPathEntity> getStationPathById(Long id) {
        return stationPathRepository.findById(id);
    }

    public StationPathEntity saveStationPath(StationPathEntity stationPath) {
        return stationPathRepository.save(stationPath);
    }

    public void deleteStationPath(Long id) {
        stationPathRepository.deleteById(id);
    }

    public List<StationPathEntity> getStationPathsByStationId(Long stationId) {
        return stationPathRepository.findByStationEntity_Id(stationId);
    }

}
