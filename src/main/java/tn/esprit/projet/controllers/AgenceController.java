package tn.esprit.projet.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projet.domain.Agence;
import tn.esprit.projet.domain.CategorieVehicule;
import tn.esprit.projet.domain.StatutVehicule;
import tn.esprit.projet.services.AgenceService;

import java.util.List;

@RestController
@RequestMapping("/api/agences")
public class AgenceController {
    private final AgenceService service;

    public AgenceController(AgenceService service) {
        this.service = service;
    }

    @GetMapping
    public List<Agence> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Agence> get(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Agence create(@RequestBody Agence a) {
        if (a.getVehicules() != null) {
            a.getVehicules().forEach(v -> {
                v.setAgence(a);
                if (v.getStatut() == null) v.setStatut(StatutVehicule.DISPONIBLE);
                if (v.getCategorie() == null) v.setCategorie(CategorieVehicule.CITADINE);
            });
        }
        if (a.getEmployes() != null) {
            a.getEmployes().forEach(e -> e.setAgence(a));
        }
        return service.save(a);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agence> update(@PathVariable Long id, @RequestBody Agence data) {
        return service.update(id, data).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return service.deleteById(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
