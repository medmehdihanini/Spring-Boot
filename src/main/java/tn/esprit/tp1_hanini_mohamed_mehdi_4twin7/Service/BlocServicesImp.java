package tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Repository.IblocRepository;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Repository.IfoyerRepository;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.Bloc;

import java.util.List;
@Service
@AllArgsConstructor
public class BlocServicesImp implements  IBlocService{
    IfoyerRepository foyerRepository;
    IblocRepository blocRepository;
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
}
