package tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Service;

import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.Foyer;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.Universite;

import java.util.List;

public interface IfoyerService {
    Foyer Ajouterfoyer(Foyer f);
    Foyer Updatefoyer(Foyer f);
    void SupprimeFoyer(long idfoyer);
    Foyer Getfoyer(long idfoyer);

    List<Foyer> GetAllfoyer();


}
