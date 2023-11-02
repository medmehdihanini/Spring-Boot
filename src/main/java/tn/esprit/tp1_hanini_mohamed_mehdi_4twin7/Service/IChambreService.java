package tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Service;

import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.Chambre;

import java.util.List;

public interface IChambreService {
    Chambre AjoutChambre(Chambre c);
    Chambre UpdateChambre(Chambre c);
    void SupprimerChambre(long idChambre);
    Chambre GetChambre(long idChambre);
    List<Chambre> GetAllChambres();

}
