package tn.esprit.projet.services.impl;

import org.springframework.stereotype.Service;
import tn.esprit.projet.domain.Maintenance;
import tn.esprit.projet.repositories.MaintenanceRepository;
import tn.esprit.projet.services.MaintenanceService;

@Service
public class MaintenanceServiceImpl extends CrudServiceImpl<Maintenance, Long, MaintenanceRepository> implements MaintenanceService {
    public MaintenanceServiceImpl(MaintenanceRepository repository) {
        super(repository);
    }

    @Override
    protected void applyUpdates(Maintenance existing, Maintenance data) {
        existing.setDateDebut(data.getDateDebut());
        existing.setDateFin(data.getDateFin());
        existing.setDescription(data.getDescription());
        existing.setVehicule(data.getVehicule());
    }
}
