package tn.esprit.projet.services;

import tn.esprit.projet.domain.Vehicule;

import java.util.Optional;

public interface VehiculeService extends CrudService<Vehicule, Long> {
    Optional<Vehicule> affecterAgence(Long vehiculeId, Long agenceId);
    boolean deleteFromAgence(Long agenceId, Long vehiculeId);
}
