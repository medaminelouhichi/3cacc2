package tn.esprit.projet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.projet.domain.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
