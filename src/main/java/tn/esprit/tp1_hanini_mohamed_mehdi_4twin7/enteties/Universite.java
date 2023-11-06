package tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Setter
@Getter
public class Universite implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idUniversite;
    @Column(unique = true)
    private String nomUniversite;
    private String adresse;
    @OneToOne
    @JsonIgnore
    private Foyer foyer;


}
