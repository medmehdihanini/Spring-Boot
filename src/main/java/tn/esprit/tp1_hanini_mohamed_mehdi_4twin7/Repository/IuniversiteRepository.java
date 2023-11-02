package tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.Universite;

public interface IuniversiteRepository extends JpaRepository<Universite,Long> {
Universite findByNomUniversite(String nom);


}
