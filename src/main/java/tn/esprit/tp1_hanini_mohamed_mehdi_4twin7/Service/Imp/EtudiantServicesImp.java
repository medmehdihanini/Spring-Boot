package tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Service.Imp;

import lombok.AllArgsConstructor;


import org.springframework.stereotype.Service;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Repository.IetudiantRepository;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Service.IEtudiantService;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.Etudiant;

import java.util.List;
@Service
@AllArgsConstructor
public class EtudiantServicesImp implements IEtudiantService {
    IetudiantRepository etudiantRepository;

    @Override
    public Etudiant AjouterEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }


    @Override
    public Boolean AjouterEtudiantAPI(Etudiant e) {


        try {

            etudiantRepository.save(e);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public Etudiant UpdateEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public void SupprimerEtdiant(long idEtudiant) {
        etudiantRepository.deleteById( idEtudiant);

    }

    @Override
    public Etudiant GetEtudiant(long idEtudiant) {
        return etudiantRepository.findById(idEtudiant).orElse(null);
    }

    @Override
    public List<Etudiant> GetAllEtudiant() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant loginetudiant(String email, String password) {

     return etudiantRepository.findEtudiantByEmailAndPassoword(email,password);
    }

    @Override
    public Etudiant getEtudiant(long id) {
        return etudiantRepository.findById(id).orElse(null);
    }
}
