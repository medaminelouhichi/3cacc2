package tn.esprit.projet.services.impl;

import org.springframework.stereotype.Service;
import tn.esprit.projet.domain.Equipement;
import tn.esprit.projet.repositories.EquipementRepository;
import tn.esprit.projet.services.EquipementService;

@Service
public class EquipementServiceImpl extends CrudServiceImpl<Equipement, Long, EquipementRepository> implements EquipementService {
    public EquipementServiceImpl(EquipementRepository repository) {
        super(repository);
    }

    @Override
    protected void applyUpdates(Equipement existing, Equipement data) {
        existing.setLibelle(data.getLibelle());
    }
}
