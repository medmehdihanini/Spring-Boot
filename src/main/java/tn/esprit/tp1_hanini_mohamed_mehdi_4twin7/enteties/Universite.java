package tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
public class Universite implements Serializable {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idUniversite;
    private String nomUniversite;
    private String adresse;
    @OneToOne
    private Foyer foyer;


}
