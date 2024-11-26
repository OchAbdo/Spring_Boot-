package com.example.projet.web.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.projet.web.model.User;

public interface UserRepository extends CrudRepository <User , Long> {
    
}
