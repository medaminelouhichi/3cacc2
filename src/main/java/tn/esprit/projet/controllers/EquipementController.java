package tn.esprit.projet.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projet.domain.Equipement;
import tn.esprit.projet.services.EquipementService;

import java.util.List;

@RestController
@RequestMapping("/api/equipements")
public class EquipementController {
    private final EquipementService service;

    public EquipementController(EquipementService service) {
        this.service = service;
    }

    @GetMapping
    public List<Equipement> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Equipement> get(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Equipement create(@RequestBody Equipement e) { return service.save(e); }

    @PutMapping("/{id}")
    public ResponseEntity<Equipement> update(@PathVariable Long id, @RequestBody Equipement data) {
        return service.update(id, data).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return service.deleteById(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
