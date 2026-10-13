package tn.esprit.projet.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projet.domain.Contrat;
import tn.esprit.projet.services.ContratService;

import java.util.List;

@RestController
@RequestMapping("/api/contrats")
public class ContratController {
    private final ContratService service;

    public ContratController(ContratService service) {
        this.service = service;
    }

    @GetMapping
    public List<Contrat> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contrat> get(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Contrat create(@RequestBody Contrat c) {
        return service.save(c);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contrat> update(@PathVariable Long id, @RequestBody Contrat data) {
        return service.update(id, data).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return service.deleteById(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
