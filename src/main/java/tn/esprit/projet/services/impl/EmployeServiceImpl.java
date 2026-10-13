package tn.esprit.projet.services.impl;

import org.springframework.stereotype.Service;
import tn.esprit.projet.domain.Employe;
import tn.esprit.projet.repositories.EmployeRepository;
import tn.esprit.projet.services.EmployeService;

@Service
public class EmployeServiceImpl extends CrudServiceImpl<Employe, Long, EmployeRepository> implements EmployeService {
    public EmployeServiceImpl(EmployeRepository repository) {
        super(repository);
    }

    @Override
    protected void applyUpdates(Employe existing, Employe data) {
        existing.setNom(data.getNom());
        existing.setPrenom(data.getPrenom());
        existing.setRole(data.getRole());
        existing.setAgence(data.getAgence());
    }
}
