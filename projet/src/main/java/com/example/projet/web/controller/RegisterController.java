package com.example.projet.web.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projet.web.model.Evennement;
import com.example.projet.web.model.Register;
import com.example.projet.web.model.User;
import com.example.projet.web.repository.EvennementRepository;
import com.example.projet.web.repository.RegisterRepository;
import com.example.projet.web.repository.UserRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;





@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private RegisterRepository registerRepository ;

    @Autowired
    private UserRepository userRepository ;

    @Autowired
    private EvennementRepository evennementRepository ;


    @GetMapping("{idu}/{id}/insc-event")
    public Register AjoutRegister(@PathVariable Long idu,
                                  @PathVariable Long id) {
            Evennement e = evennementRepository.findById(id).get();
            User u = userRepository.findById(idu).get();
            Register r = new Register() ;
            r.setUser(u);
            r.setEvennement(e);                       
       
        return registerRepository.save(r)   ;
    }


    @GetMapping("/{id}/liste")
    public List<User> afficheUserEvent(@PathVariable Long id) {
        return registerRepository.findUsersByEvennementId(id);
    }
    
    
    
    
}
