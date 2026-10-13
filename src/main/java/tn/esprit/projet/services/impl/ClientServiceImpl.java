package tn.esprit.projet.services.impl;

import org.springframework.stereotype.Service;
import tn.esprit.projet.domain.Client;
import tn.esprit.projet.repositories.ClientRepository;
import tn.esprit.projet.services.ClientService;

@Service
public class ClientServiceImpl extends CrudServiceImpl<Client, Long, ClientRepository> implements ClientService {
    public ClientServiceImpl(ClientRepository repository) {
        super(repository);
    }

    @Override
    protected void applyUpdates(Client existing, Client data) {
        existing.setNom(data.getNom());
        existing.setPrenom(data.getPrenom());
        existing.setEmail(data.getEmail());
        existing.setTelephone(data.getTelephone());
        existing.setNumPermis(data.getNumPermis());
        existing.setDateInscription(data.getDateInscription());
    }
}
