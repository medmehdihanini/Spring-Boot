package tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
public class Foyer implements Serializable {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private Long idFoyer;


    private String nomFoyer;
    private Long capaciteFoyer;
    @OneToOne(mappedBy = "foyer")
    private Universite universite;

    @OneToMany(mappedBy = "foyer")
    private Set<Bloc> blocs;

}
