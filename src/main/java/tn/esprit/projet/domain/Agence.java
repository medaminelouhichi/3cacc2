package tn.esprit.projet.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity @Table(name = "agence")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Agence {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgence;
    @Column(nullable = false, length = 100) private String nom;
    @Column(nullable = false, length = 100) private String ville;
    @Column(nullable = false, length = 255) private String adresse;
    @Column(nullable = false, length = 20) private String telephone;

    @OneToMany(mappedBy = "agence", cascade = CascadeType.ALL)
    private List<Employe> employes = new ArrayList<>();
    //@JsonIgnore
    @OneToMany(mappedBy = "agence", cascade = CascadeType.ALL,
                fetch= FetchType.LAZY, orphanRemoval = true)
    @JsonProperty
    private List<Vehicule> vehicules = new ArrayList<>();
}
