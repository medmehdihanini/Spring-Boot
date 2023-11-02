package tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Service;

import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.Etudiant;

import java.util.List;

public interface IEtudiantService {
    Etudiant AjouterEtudiant(Etudiant e);
    Etudiant UpdateEtudiant (Etudiant e);
    void SupprimerEtdiant (long idEtudiant);
     Etudiant GetEtudiant(long idEtudiant);
     List<Etudiant> GetAllEtudiant();



}
