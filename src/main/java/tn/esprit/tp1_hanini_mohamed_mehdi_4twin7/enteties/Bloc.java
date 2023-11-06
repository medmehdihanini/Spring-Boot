package tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
@Setter
@Getter
public class Bloc implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBloc;
    @Column(unique = true)
    private String nomBloc;
    private Long capaciteBloc;
    @JsonIgnore
    @ManyToOne
    private Foyer foyer;
    @JsonIgnore
    @OneToMany(mappedBy = "bloc2",cascade = {CascadeType.REMOVE,CascadeType.PERSIST},fetch = FetchType.EAGER)
    private Set<Chambre> chambres;
}


