package tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Service;

import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.Etudiant;

import java.util.List;

public interface IEtudiantService {
    Etudiant AjouterEtudiant(Etudiant e);
    Boolean AjouterEtudiantAPI(Etudiant e);
    Etudiant UpdateEtudiant (Etudiant e);
    void SupprimerEtdiant (long idEtudiant);
     Etudiant GetEtudiant(long idEtudiant);
     List<Etudiant> GetAllEtudiant();
     Etudiant loginetudiant(String email, String password);
     Etudiant getEtudiant(long id );
     Etudiant etudiantBlocked(long id);
     Etudiant etatOflline(long id);



}
