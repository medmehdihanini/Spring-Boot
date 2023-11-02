package tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Repository.IblocRepository;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Repository.IchambreRepository;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Repository.IfoyerRepository;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.Bloc;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.Chambre;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.Foyer;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class BlocServicesImp implements  IBlocService{
    IfoyerRepository foyerRepository;
    IblocRepository blocRepository;
  IchambreRepository chambreRepository;
    @Override
    public Bloc AjouterBloc(Bloc b) {
        return blocRepository.save(b) ;
    }

    @Override
    public Bloc UpdateBloc(Bloc b) {
        return blocRepository.save(b);
    }

    @Override
    public void SupprimerBloc(long idBloc) {
blocRepository.deleteById(idBloc);
    }

    @Override
    public Bloc GetBloc(long idBloc) {
        return blocRepository.findById(idBloc).orElse(null);
    }

    @Override
    public List<Bloc> GetAllBlocs() {
        return blocRepository.findAll();
    }
@Transactional
    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, String nomBloc) {
        Bloc b = blocRepository.findByNomBloc(nomBloc);
        for(Long id : numChambre){
            Chambre c = chambreRepository.findById(id).orElse(null);
            c.setBloc2(b);
        }
        return b;
    }
@Transactional
    @Override
    public Bloc affecterBlocAFoyer(String nomBloc, String nomFoyer) {
        Bloc b = blocRepository.findByNomBloc(nomBloc);
        Foyer f = foyerRepository.findByNomFoyer(nomFoyer);
        b.setFoyer(f);
        return b;
    }
}
