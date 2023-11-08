package tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Service.Imp;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Repository.IblocRepository;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Repository.IchambreRepository;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Repository.IfoyerRepository;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Service.IChambreService;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.Bloc;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.Chambre;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.Foyer;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.TypeChambre;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ChambreServicesImp implements IChambreService {
    IchambreRepository chambreRepository;
    IblocRepository blocRepository;
    IfoyerRepository foyerRepository;

    @Override
    public Chambre AjoutChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public Chambre UpdateChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public void SupprimerChambre(long idChambre) {
        chambreRepository.deleteById(idChambre);
    }

    @Override
    public Chambre GetChambre(long idChambre) {
        return chambreRepository.findById(idChambre).orElse(null);
    }

    @Override
    public List<Chambre> GetAllChambres() {
        return chambreRepository.findAll();
    }

    @Override
    public List<Chambre> getChambresParNomBloc(String nomBloc) {
        Bloc b = blocRepository.findByNomBloc(nomBloc);
        List<Chambre> chambres = new ArrayList<>();
        for(Chambre c : b.getChambres()){
            chambres.add(c);

        }
        return chambres;
    }

    @Override
    public long nbChambreParTypeEtBloc(TypeChambre type, long idBloc) {
        Bloc b = blocRepository.findById(idBloc).orElse(null);
        int nbrchambre = 0;
        for(Chambre c : b.getChambres()){
            if (c.getTypeChambre()==type) {
                nbrchambre++;
            }
        }



        return  nbrchambre;
    }

    @Override
public List<Chambre> getChambresNonReserveParNomFoyerEtTypeChambre(String nomFoyer, TypeChambre type) {

  Foyer foyer = foyerRepository.findByNomFoyer(nomFoyer);
        List<Chambre> chambre = new ArrayList<>();
  List<Bloc> blocs = blocRepository.findByFoyer(foyer);
  for (Bloc b : blocs) {

      chambre.addAll(chambreRepository.findByTypeChambreAndBloc2AndReservations(type,b,null));
  }




  return chambre;
}

    @Override
    public List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC) {
        Bloc b = blocRepository.findById(idBloc).orElse(null);

return  chambreRepository.findByBloc2AndTypeChambre(b,typeC);  }


}


