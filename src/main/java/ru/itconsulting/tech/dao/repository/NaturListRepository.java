package ru.itconsulting.tech.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itconsulting.tech.dao.entity.NaturListEntity;

@Repository
public interface NaturListRepository extends JpaRepository<NaturListEntity, Long> {
}
