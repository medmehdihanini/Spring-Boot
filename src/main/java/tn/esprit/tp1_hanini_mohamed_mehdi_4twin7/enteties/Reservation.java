package tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.io.Serializable;
import java.util.Locale;
import java.util.Set;
@Setter
@Getter
@Entity
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private long idReservation;
    private String numReservation;
    private LocalDate anneUniversitaire;
    private boolean estvalide;
    @JsonIgnore
    @ManyToOne
    private Chambre chamber;
    @JsonIgnore
    @ManyToMany
    private Set<Etudiant> etudiants;
}
