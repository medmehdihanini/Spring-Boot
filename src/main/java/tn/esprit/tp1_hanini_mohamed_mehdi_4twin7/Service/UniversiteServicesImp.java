package tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Repository.IuniversiteRepository;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.Reservation;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.Universite;

import java.util.List;
@Service
@AllArgsConstructor
public class UniversiteServicesImp implements  IUniversiteService{
IuniversiteRepository universiteRepository;
    @Override
    public Universite AjouterUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite UpdateUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public void SupprimerUniversite(long idUniversite) {
universiteRepository.deleteById(idUniversite);
    }

    @Override
    public Universite GetUniversite(long idUniversite) {
        return universiteRepository.findById(idUniversite).orElse(null);
    }

    @Override
    public List<Universite> GetAllUuniversite() {
        return universiteRepository.findAll();
    }
}
