package tn.esprit.projet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.projet.domain.Maintenance;

public interface MaintenanceRepository extends JpaRepository<Maintenance, Long> {
}
