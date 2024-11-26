package com.example.projet.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.projet.web.model.Register;
import com.example.projet.web.model.User;

public interface RegisterRepository extends CrudRepository<Register , Long> {
    
    
    @Query("SELECT r.user FROM Register r WHERE r.evennement.id = :evennementId")
    List<User> findUsersByEvennementId(@Param("evennementId") Long evennementId);

}
