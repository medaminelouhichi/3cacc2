package tn.esprit.projet.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projet.domain.Paiement;
import tn.esprit.projet.services.PaiementService;

import java.util.List;

@RestController
@RequestMapping("/api/paiements")
public class PaiementController {
    private final PaiementService service;

    public PaiementController(PaiementService service) {
        this.service = service;
    }

    @GetMapping
    public List<Paiement> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Paiement> get(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Paiement create(@RequestBody Paiement p) { return service.save(p); }

    @PutMapping("/{id}")
    public ResponseEntity<Paiement> update(@PathVariable Long id, @RequestBody Paiement data) {
        return service.update(id, data).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return service.deleteById(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
