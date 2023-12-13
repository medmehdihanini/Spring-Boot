package tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Service.Imp;

import lombok.AllArgsConstructor;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Repository.IetudiantRepository;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Service.IEtudiantService;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.Etudiant;

import javax.swing.plaf.InsetsUIResource;
import java.util.List;
@Service
@AllArgsConstructor
public class EtudiantServicesImp implements IEtudiantService {
    IetudiantRepository etudiantRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    @Override
    public Etudiant AjouterEtudiant(Etudiant e) {
        e.setRole("user");
        e.setEtat(1);
        String passwordcode = this.passwordEncoder.encode(e.getPassoword());
        e.setPassoword(passwordcode);
        etudiantRepository.save(e);
        return etudiantRepository.save(e);
    }


    @Override
    public Boolean AjouterEtudiantAPI(Etudiant e) {


        try {
            e.setRole("user");
e.setEtat(0);
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
        Etudiant etudiant = etudiantRepository.findEtudiantByEmail(email);
        System.out.println("edha etudinat eli jebtou "+etudiant.getEmail());
        if(passwordEncoder.matches(password,etudiant.getPassoword())&& etudiant.getEtat()!=5){
            System.out.println("fi west if  "+etudiant.getEmail());

            etudiant.setEtat(1);
            etudiantRepository.save(etudiant);
            return etudiant;

        }


     return null;
    }

    @Override
    public Etudiant getEtudiant(long id) {
        return etudiantRepository.findById(id).orElse(null);
    }

    @Override
    public Etudiant etudiantBlocked(long id) {
        Etudiant etudiant = etudiantRepository.findById(id).orElse(null);
        assert etudiant != null;
        etudiant.setEtat(5);
        return etudiantRepository.save(etudiant);
    }

    @Override
    public Etudiant unblock(long id) {
        Etudiant etudiant = etudiantRepository.findById(id).orElse(null);
        assert etudiant != null;
        etudiant.setEtat(0);
        return etudiantRepository.save(etudiant);    }

    @Override
    public Etudiant etatOflline(long id) {
        Etudiant etudiant = etudiantRepository.findById(id).orElse(null);
        assert etudiant != null;
        etudiant.setEtat(0);
        return etudiantRepository.save(etudiant);
    }
}
