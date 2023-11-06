package tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Service.Imp;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Repository.IblocRepository;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Repository.IfoyerRepository;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Repository.IuniversiteRepository;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Service.IfoyerService;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.Bloc;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.Foyer;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.Universite;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor // edhy constructeur maa final
@Primary
//@AllArgsConstructor edhy nektbhouha mnghyr final

public class FoyerServicesImp implements IfoyerService {
    //@Autowired  injection par attribut foug attribue tythat

  final  IfoyerRepository foyerRepository;
    // injection par constructeur
 final IuniversiteRepository universiteRepository;
 final IblocRepository blocRepository;

    @Override
    public Foyer Ajouterfoyer(Foyer f) {
        System.out.println(f);
        return foyerRepository.save(f);
    }

    @Override
    public Foyer Updatefoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public void SupprimeFoyer(long idfoyer) {
        foyerRepository.deleteById(idfoyer);

    }

    @Override
    public Foyer Getfoyer(long idfoyer) {
        return foyerRepository.findById(idfoyer).orElse(null); // ki nheb manwagfech probleme
        //        return foyerRepository.findById(idfoyer).get(); kan lgee object yraj3ou kan malgech exception
    }

    @Override
    public List<Foyer> GetAllfoyer() {
        return foyerRepository.findAll();
    }

    @Override
    @Transactional
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {

        Universite universite = universiteRepository.findById(idUniversite).orElse(null);
        foyer.setUniversite(universite);

        foyer = foyerRepository.save(foyer);

        for(Bloc b : foyer.getBlocs()) {
            b.setFoyer(foyer);
            blocRepository.save(b);
        }

        return foyer;
    }



}
