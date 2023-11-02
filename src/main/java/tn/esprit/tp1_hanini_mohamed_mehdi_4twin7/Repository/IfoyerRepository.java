package tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.Foyer;

public interface IfoyerRepository extends JpaRepository<Foyer,Long> {
    Foyer findByNomFoyer(String nomFoyer);
}
