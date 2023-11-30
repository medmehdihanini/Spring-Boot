package tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.Etudiant;

public interface IetudiantRepository extends JpaRepository<Etudiant,Long> {
    Etudiant findEtudiantByCin(long cin);
    Etudiant findEtudiantByEmailAndPassoword(String email,String passoword);

    Etudiant findEtudiantByEmail(String email);
}
