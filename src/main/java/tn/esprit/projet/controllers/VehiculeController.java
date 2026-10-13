package tn.esprit.projet.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projet.domain.Vehicule;
import tn.esprit.projet.services.VehiculeService;

import java.util.List;

@RestController
@RequestMapping("/api/vehicules")
public class VehiculeController {
    private final VehiculeService service;

    public VehiculeController(VehiculeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Vehicule> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicule> get(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Vehicule create(@RequestBody Vehicule v) {
        return service.save(v);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehicule> update(@PathVariable Long id, @RequestBody Vehicule data) {
        return service.update(id, data).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{vehiculeId}/agence/{agenceId}")
    public ResponseEntity<Vehicule> affecterAgence(
            @PathVariable Long vehiculeId,
            @PathVariable Long agenceId) {
        return service.affecterAgence(vehiculeId, agenceId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/agence/{agenceId}/vehicule/{vehiculeId}")
    public ResponseEntity<?> deleteFromAgence(
            @PathVariable Long agenceId,
            @PathVariable Long vehiculeId) {
        return service.deleteFromAgence(agenceId, vehiculeId)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return service.deleteById(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
