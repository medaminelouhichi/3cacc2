package tn.esprit.projet.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projet.domain.Employe;
import tn.esprit.projet.services.EmployeService;

import java.util.List;

@RestController
@RequestMapping("/api/employes")
public class EmployeController {
    private final EmployeService service;

    public EmployeController(EmployeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Employe> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Employe> get(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Employe create(@RequestBody Employe e) { return service.save(e); }

    @PutMapping("/{id}")
    public ResponseEntity<Employe> update(@PathVariable Long id, @RequestBody Employe data) {
        return service.update(id, data).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return service.deleteById(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
