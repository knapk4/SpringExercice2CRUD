package com.example.demo.service;

import com.example.demo.model.Personne;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonneService {

     private final List<Personne> personnes = new ArrayList<>(); // Liste de personnes (vide de base)

     public List<Personne> findAll() { // Retourne la liste des personnes
         return personnes;
     }

     public  Personne findById(Long id) { // Retourne une personne par son id (si elle existe)
         for (Personne personne : personnes) {
             if (personne.getId().equals(id)){
                 return personne;
             }
         }
         return null;
     }

     public Personne save(Personne personne) { // Ajoute une personne à la liste
         personnes.add(personne);
         return personne;
     }

     public Personne update(Personne personne) { // Met a jour une personne de la liste (si elle existe)
         for (Personne personneUpdate : personnes) {
             if (personneUpdate.getId().equals(personne.getId())) { // On regarde si l'id donne correspond une personnes déjà enregistré
                 personneUpdate.setNom(personne.getNom()); // on update les champs s'ils sont présents
                 personneUpdate.setPrenom(personne.getPrenom());
                 personneUpdate.setAge(personne.getAge());
                 return personneUpdate;
             }
         }
         return null;
     }

     public Personne delete(Long id) {
         for (Personne personneDelete : personnes) {
             if (personneDelete.getId().equals(id)) {
                personnes.remove(personneDelete);
                return personneDelete;
             }
         }
         return null;
     }
}
