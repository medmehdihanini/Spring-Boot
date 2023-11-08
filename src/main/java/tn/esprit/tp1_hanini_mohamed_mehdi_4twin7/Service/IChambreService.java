package tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Service;

import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.Chambre;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.TypeChambre;

import java.util.List;

public interface IChambreService {
    Chambre AjoutChambre(Chambre c);
    Chambre UpdateChambre(Chambre c);
    void SupprimerChambre(long idChambre);
    Chambre GetChambre(long idChambre);
    List<Chambre> GetAllChambres();
    List<Chambre> getChambresParNomBloc( String nomBloc) ;
    long nbChambreParTypeEtBloc(TypeChambre type, long idBloc) ;
    List<Chambre> getChambresNonReserveParNomFoyerEtTypeChambre( String nomFoyer,TypeChambre type) ;
    List<Chambre> getChambresParBlocEtType (long idBloc, TypeChambre typeC) ;
}
