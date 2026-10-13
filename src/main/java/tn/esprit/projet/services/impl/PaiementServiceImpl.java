package tn.esprit.projet.services.impl;

import org.springframework.stereotype.Service;
import tn.esprit.projet.domain.Paiement;
import tn.esprit.projet.repositories.PaiementRepository;
import tn.esprit.projet.services.PaiementService;

@Service
public class PaiementServiceImpl extends CrudServiceImpl<Paiement, Long, PaiementRepository> implements PaiementService {
    public PaiementServiceImpl(PaiementRepository repository) {
        super(repository);
    }

    @Override
    protected void applyUpdates(Paiement existing, Paiement data) {
        existing.setMontant(data.getMontant());
        existing.setDatePaiement(data.getDatePaiement());
        existing.setModePaiement(data.getModePaiement());
        existing.setContrat(data.getContrat());
    }
}
