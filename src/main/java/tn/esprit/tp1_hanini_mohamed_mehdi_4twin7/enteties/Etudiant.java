package tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
public class Etudiant implements Serializable {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEtudiant;
    private String nomEt;
    private String prenomet;
    private long Cin;
    private String ecole;
    private Date dateNaissance;
    @ManyToMany(mappedBy = "etudiants")
    private Set<Reservation> reservations;
}
