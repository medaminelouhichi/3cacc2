package tn.esprit.projet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.projet.domain.Contrat;

public interface ContratRepository extends JpaRepository<Contrat, Long> {
}
