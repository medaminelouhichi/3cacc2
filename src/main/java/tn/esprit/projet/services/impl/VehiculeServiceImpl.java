package tn.esprit.projet.services.impl;

import org.springframework.stereotype.Service;
import tn.esprit.projet.domain.Agence;
import tn.esprit.projet.domain.Vehicule;
import tn.esprit.projet.repositories.AgenceRepository;
import tn.esprit.projet.repositories.VehiculeRepository;
import tn.esprit.projet.services.VehiculeService;

import java.util.Optional;

@Service
public class VehiculeServiceImpl extends CrudServiceImpl<Vehicule, Long, VehiculeRepository> implements VehiculeService {
    private final AgenceRepository agenceRepository;

    public VehiculeServiceImpl(VehiculeRepository repository, AgenceRepository agenceRepository) {
        super(repository);
        this.agenceRepository = agenceRepository;
    }

    @Override
    public Optional<Vehicule> affecterAgence(Long vehiculeId, Long agenceId) {
        Optional<Agence> agence = agenceRepository.findById(agenceId);
        if (agence.isEmpty()) {
            return Optional.empty();
        }

        return repository.findById(vehiculeId).map(vehicule -> {
            vehicule.setAgence(agence.get());
            return repository.save(vehicule);
        });
    }

    @Override
    public boolean deleteFromAgence(Long agenceId, Long vehiculeId) {
        return repository.findById(vehiculeId)
                .filter(vehicule -> vehicule.getAgence() != null
                        && agenceId.equals(vehicule.getAgence().getIdAgence()))
                .map(vehicule -> {
                    repository.delete(vehicule);
                    return true;
                })
                .orElse(false);
    }

    @Override
    protected void applyUpdates(Vehicule existing, Vehicule data) {
        existing.setImmatriculation(data.getImmatriculation());
        existing.setMarque(data.getMarque());
        existing.setModele(data.getModele());
        existing.setCategorie(data.getCategorie());
        existing.setTarifJournalier(data.getTarifJournalier());
        existing.setStatut(data.getStatut());
        if (data.getAgence() != null && data.getAgence().getIdAgence() != null) {
            Agence managedAgence = agenceRepository.findById(data.getAgence().getIdAgence())
                .orElseThrow(() -> new IllegalArgumentException("Agence not found: " + data.getAgence().getIdAgence()));
            existing.setAgence(managedAgence);
        }
    }
}
