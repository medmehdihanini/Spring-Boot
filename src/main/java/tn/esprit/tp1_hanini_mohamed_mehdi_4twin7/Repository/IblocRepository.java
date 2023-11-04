package tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.Bloc;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.Chambre;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.Foyer;

import java.util.List;

public interface IblocRepository extends JpaRepository<Bloc,Long> {
    Bloc findByNomBloc(String nombloc);
    List<Bloc> findByFoyer(Foyer foyer);

}
