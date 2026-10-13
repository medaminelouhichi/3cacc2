package tn.esprit.projet.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tn.esprit.projet.domain.Agence;
import tn.esprit.projet.domain.Client;
import tn.esprit.projet.domain.Vehicule;
import tn.esprit.projet.domain.CategorieVehicule;
import tn.esprit.projet.domain.StatutVehicule;
import tn.esprit.projet.repositories.AgenceRepository;
import tn.esprit.projet.repositories.ClientRepository;
import tn.esprit.projet.repositories.VehiculeRepository;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final AgenceRepository agenceRepo;
    private final ClientRepository clientRepo;
    private final VehiculeRepository vehiculeRepo;

    public DataLoader(AgenceRepository agenceRepo, ClientRepository clientRepo, VehiculeRepository vehiculeRepo) {
        this.agenceRepo = agenceRepo;
        this.clientRepo = clientRepo;
        this.vehiculeRepo = vehiculeRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        if (agenceRepo.count() == 0) {
            Agence a = new Agence();
            a.setNom("Agence Centrale");
            a.setVille("Tunis");
            a.setAdresse("1 Rue Principale");
            a.setTelephone("21234567");
            agenceRepo.save(a);

            Client c = new Client();
            c.setNom("Doe");
            c.setPrenom("John");
            c.setEmail("john.doe@example.com");
            c.setTelephone("99887766");
            c.setNumPermis("TN123456");
            c.setDateInscription(LocalDate.now());
            clientRepo.save(c);

            Vehicule v = new Vehicule();
            v.setImmatriculation("123-ABC");
            v.setMarque("Toyota");
            v.setModele("Corolla");
            v.setCategorie(CategorieVehicule.CITADINE);
            v.setTarifJournalier(new BigDecimal("45.00"));
            v.setStatut(StatutVehicule.DISPONIBLE);
            v.setAgence(a);
            vehiculeRepo.save(v);
        }
    }
}
