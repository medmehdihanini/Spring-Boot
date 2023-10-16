package tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
@Setter
@Getter
public class Bloc implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idBloc;
    private String nomBloc;
    private Long capaciteBloc;

    @ManyToOne
    private Foyer foyer;

    @OneToMany(mappedBy = "bloc2")
    private Set<Chambre> chambres;
}


