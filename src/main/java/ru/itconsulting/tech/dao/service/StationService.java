package ru.itconsulting.tech.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itconsulting.tech.dao.entity.StationEntity;
import ru.itconsulting.tech.dao.entity.StationPathEntity;
import ru.itconsulting.tech.dao.repository.StationRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class StationService {

    @Autowired
    private StationRepository stationRepository;

    public List<StationEntity> getAllStations() {
        return stationRepository.findAll();
    }

    public Optional<StationEntity> getStationById(Long id) {
        return stationRepository.findById(id);
    }

    public StationEntity saveStation(StationEntity station) {
        return stationRepository.save(station);
    }

    public void deleteStation(Long id) {
        stationRepository.deleteById(id);
    }

    public List<StationPathEntity> getPathListByStationId(Long stationId) {
        StationEntity station = stationRepository.findById(stationId).orElseThrow(
                () -> new EntityNotFoundException("Station with id " + stationId + " not found"));

        return station.getPathList();
    }

}
