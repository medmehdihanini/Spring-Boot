package tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Repository.IchambreRepository;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.Chambre;

import java.util.List;

@Service
@AllArgsConstructor
public class ChambreServicesImp implements IChambreService {
    IchambreRepository chambreRepository;

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
}
