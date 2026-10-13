package tn.esprit.projet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.projet.domain.Agence;

public interface AgenceRepository extends JpaRepository<Agence, Long> {
}
