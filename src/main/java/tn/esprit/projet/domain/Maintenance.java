package tn.esprit.projet.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity @Table(name = "maintenance")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Maintenance {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMaintenance;
    @Column(nullable = false) private LocalDate dateDebut;
    @Column(nullable = false) private LocalDate dateFin;
    @Column(nullable = false, length = 500) private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicule_id", nullable = false)
    private Vehicule vehicule;
}
