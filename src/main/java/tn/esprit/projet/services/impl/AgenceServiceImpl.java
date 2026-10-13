package tn.esprit.projet.services.impl;

import org.springframework.stereotype.Service;
import tn.esprit.projet.domain.Agence;
import tn.esprit.projet.repositories.AgenceRepository;
import tn.esprit.projet.services.AgenceService;

@Service
public class AgenceServiceImpl extends CrudServiceImpl<Agence, Long, AgenceRepository> implements AgenceService {
    public AgenceServiceImpl(AgenceRepository repository) {
        super(repository);
    }

    @Override
    protected void applyUpdates(Agence existing, Agence data) {
        existing.setNom(data.getNom());
        existing.setVille(data.getVille());
        existing.setAdresse(data.getAdresse());
        existing.setTelephone(data.getTelephone());
    }
}
