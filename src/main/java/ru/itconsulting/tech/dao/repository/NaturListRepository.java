package ru.itconsulting.tech.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itconsulting.tech.dao.entity.NaturList;

@Repository
public interface NaturListRepository extends JpaRepository<NaturList, Long> {
}
