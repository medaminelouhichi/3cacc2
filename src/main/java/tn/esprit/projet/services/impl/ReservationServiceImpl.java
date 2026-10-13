package tn.esprit.projet.services.impl;

import org.springframework.stereotype.Service;
import tn.esprit.projet.domain.Reservation;
import tn.esprit.projet.repositories.ReservationRepository;
import tn.esprit.projet.services.ReservationService;

@Service
public class ReservationServiceImpl extends CrudServiceImpl<Reservation, Long, ReservationRepository> implements ReservationService {
    public ReservationServiceImpl(ReservationRepository repository) {
        super(repository);
    }

    @Override
    protected void applyUpdates(Reservation existing, Reservation data) {
        existing.setDateDebut(data.getDateDebut());
        existing.setDateFin(data.getDateFin());
        existing.setStatut(data.getStatut());
        existing.setClient(data.getClient());
        existing.setVehicule(data.getVehicule());
    }
}
