package ru.itconsulting.tech.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StationPath extends JpaRepository<StationPath, Long> {
}
