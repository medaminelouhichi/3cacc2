package tn.esprit.projet.services.impl;

import org.springframework.stereotype.Service;
import tn.esprit.projet.domain.Contrat;
import tn.esprit.projet.repositories.ContratRepository;
import tn.esprit.projet.services.ContratService;

@Service
public class ContratServiceImpl extends CrudServiceImpl<Contrat, Long, ContratRepository> implements ContratService {
    public ContratServiceImpl(ContratRepository repository) {
        super(repository);
    }

    @Override
    protected void applyUpdates(Contrat existing, Contrat data) {
        existing.setDateSignature(data.getDateSignature());
        existing.setMontantTotal(data.getMontantTotal());
        existing.setValide(data.isValide());
        existing.setReservation(data.getReservation());
    }
}
