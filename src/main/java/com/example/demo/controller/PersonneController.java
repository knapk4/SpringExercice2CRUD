package com.example.demo.controller;

import com.example.demo.model.Personne;
import com.example.demo.service.PersonneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personnes")
public class PersonneController {

    private final PersonneService personneService;

    public PersonneController(PersonneService personneService){
        this.personneService = personneService;
    }

    @GetMapping("/all")
    public List<Personne> findAll() {
        return personneService.findAll();
    }

    @GetMapping("/{id}")
    public Personne findById(@PathVariable Long id) {
        return personneService.findById(id);
    }

    @PostMapping("/add")
    public Personne save(@RequestBody Personne personne) {
        return personneService.save(personne);
    }

    @PatchMapping("/patch/{id}")
    public Personne update(@RequestBody Personne personne, @PathVariable Long id) {
        personne.setId(id);
        return personneService.update(personne);
    }

    @DeleteMapping("/delete/{id}")
    public Personne delete(@PathVariable Long id) {
        return personneService.delete(id);
    }


}
