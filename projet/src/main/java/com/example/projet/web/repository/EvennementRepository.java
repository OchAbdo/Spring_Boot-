package com.example.projet.web.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.projet.web.model.Evennement;

public interface EvennementRepository extends CrudRepository<Evennement , Long> {

     @Query("SELECT e FROM Evennement e WHERE e.date = :dateEvennement")
     List<Evennement> findEvennementsByDate(@Param("dateEvennement") String dateEvennement);

     @Query("SELECT e FROM Evennement e WHERE e.lieu = :lieuEvennement")
     List<Evennement> findEvennementsByLieu(@Param("lieuEvennement") String lieuEvennement);
}
