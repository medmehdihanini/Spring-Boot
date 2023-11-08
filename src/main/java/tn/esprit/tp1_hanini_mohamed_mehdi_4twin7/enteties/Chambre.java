package tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.Set;

@Entity
@Setter
@Getter
public class Chambre implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long idChambre;
    private long numchambre;
    @Enumerated(EnumType.STRING)
    private TypeChambre typeChambre;
    @JsonIgnore
    @ManyToOne
    private Bloc bloc2;
    @JsonIgnore
    @OneToMany
    private Set<Reservation> reservations;

}
