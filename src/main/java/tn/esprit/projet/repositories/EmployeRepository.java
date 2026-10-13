package tn.esprit.projet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.projet.domain.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Long> {
}
