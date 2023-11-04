package tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.Reservation;

import java.util.Date;
import java.util.List;

public interface IresrvationRepository extends JpaRepository<Reservation,Long> {

    List<Reservation> findByAnneUniversitaireBetween(Date debutAnnee, Date finAnnee);
}
