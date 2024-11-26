package com.example.projet.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projet.web.model.User;
import com.example.projet.web.repository.UserRepository;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;





@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/inscrire")
    public User UserInscrire(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PostMapping("/{id}/delete")
    public void DeleteUser(@PathVariable Long id) {

            userRepository.deleteById(id);
            System.out.println("delete success");
    }

    @PutMapping("/{id}/modifier")
    public User UserModifier(@PathVariable Long id, @RequestBody User nUser) {
        //TODO: process PUT request
        
        return userRepository.findById(id)
                             .map(user ->{  nUser.setNom(user.getNom());
                                            nUser.setPrenom(user.getPrenom());
                                            nUser.setMail(user.getMail());
                                            nUser.setTlph(user.getTlph());
                                            return userRepository.save(user);})
                            .orElseGet(()->{
                                            return userRepository.save(nUser);});
    }
    

    @GetMapping("/liste")
    public Iterable<User> ShowUser() {
        return userRepository.findAll();
    }
    
    


    




    
}
