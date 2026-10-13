package tn.esprit.projet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.projet.domain.Vehicule;

public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {
}
