package tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Service;

import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.Universite;

import java.util.List;

public interface IUniversiteService {
    Universite AjouterUniversite(Universite u);
    Universite UpdateUniversite(Universite u);
    void SupprimerUniversite(long idUniversite);
    Universite GetUniversite(long idUniversite);
    List<Universite> GetAllUuniversite();


}
