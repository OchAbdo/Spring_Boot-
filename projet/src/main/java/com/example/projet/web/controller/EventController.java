package com.example.projet.web.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.projet.web.model.Evennement;
import com.example.projet.web.repository.EvennementRepository;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;









@RestController
@RequestMapping("/event")
public class EventController {

        @Autowired
        private EvennementRepository evennementRepository;

        @PostMapping("/ajout")
        public Evennement AjoutEvent(@RequestBody Evennement evennement) {
            return evennementRepository.save(evennement);
        }

        @GetMapping("/liste")
        public Iterable<Evennement> AffichEvent() {
            return evennementRepository.findAll();
        }
        @GetMapping("/{id}/evennement")
        public Optional<Evennement> AfficheEventByid(@PathVariable Long id) {
            return evennementRepository.findById(id);
        }
        

        @PutMapping("/{id}/modifier")
        public Evennement UpdateEvent(@PathVariable Long id, 
                                      @RequestBody Evennement newEvennement) { 
            return evennementRepository.findById(id)
            .map(evennemnt ->{
                                                                evennemnt.setTitre(newEvennement.getTitre());
                                                                evennemnt.setDescription(newEvennement.getDescription());
                                                                evennemnt.setDate(newEvennement.getDate());
                                                                evennemnt.setLieu(newEvennement.getLieu());
                                                                evennemnt.setNbplace(newEvennement.getNbplace());
                                                                evennemnt.setPrix(newEvennement.getPrix());
                                                                evennemnt.setCategorie(newEvennement.getCategorie());    
                                                                return evennementRepository.save(evennemnt);            
            })
            .orElseGet(() -> {
                                return evennementRepository.save(newEvennement);
            });
        }

        @PostMapping("/{id}/delete")
        public void DeleteEvent(@PathVariable Long id) {
            evennementRepository.deleteById(id);
            System.out.println("delete success");
        }

       @GetMapping("/{date}/listedate")
       public List<Evennement> filtrageDate(@PathVariable String date) {
           return evennementRepository.findEvennementsByDate(date) ;
       }

       @GetMapping("/{localisation}/listeLieu")
       public List<Evennement> filtrageLocalisation(@PathVariable String localisation) {
           return evennementRepository.findEvennementsByLieu(localisation);
       }
       
       
       
        


        

        
        
        



    
}
