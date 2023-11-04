package tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.Bloc;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.Chambre;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.Reservation;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.TypeChambre;

import java.util.List;

public interface IchambreRepository extends JpaRepository<Chambre,Long> {
    List<Chambre> findByTypeChambreAndBloc2AndReservations(TypeChambre type, Bloc bloc, Reservation reservation);



}
