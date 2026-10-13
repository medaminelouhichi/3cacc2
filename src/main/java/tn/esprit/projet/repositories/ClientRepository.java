package tn.esprit.projet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.projet.domain.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
