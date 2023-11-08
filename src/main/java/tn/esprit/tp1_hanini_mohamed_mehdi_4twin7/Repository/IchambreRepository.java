package tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.Bloc;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.Chambre;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.Reservation;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.TypeChambre;

import java.util.List;

public interface IchambreRepository extends JpaRepository<Chambre,Long> {
    List<Chambre> findByTypeChambreAndBloc2AndReservations(TypeChambre type, Bloc bloc, Reservation reservation);
Chambre findChambreByReservations(Reservation reservation);
List<Chambre> findByBloc2AndTypeChambre(Bloc bloc, TypeChambre type);
/*
    @Query("SELECT c FROM Chambre c WHERE c.bloc = :bloc AND c.typeChambre = :type")
    List<Chambre> findByBlocAndTypeChambre(@Param("bloc") Bloc bloc, @Param("type") TypeChambre type);
    */


}
