package tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Repository.IblocRepository;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Repository.IchambreRepository;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Repository.IetudiantRepository;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Repository.IresrvationRepository;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.Reservation;

import java.util.Date;
import java.util.List;
@Service
@AllArgsConstructor
public class ReservationServicesImp implements IReservationService{
    IresrvationRepository resrvationRepository;
    IchambreRepository chambreRepository;
    IetudiantRepository etudiantRepository;
    IblocRepository iblocRepository;
    @Override
    public Reservation AjouterReservation(Reservation r) {
        return resrvationRepository.save(r);
    }

    @Override
    public Reservation UpdateReservation(Reservation r) {
        return resrvationRepository.save(r);
    }

    @Override
    public void SupprimerReservation(long idReservation) {
resrvationRepository.deleteById( idReservation);
    }

    @Override
    public Reservation GetReservation(long idReservation) {
        return resrvationRepository.findById( idReservation).orElse(null);
    }

    @Override
    public List<Reservation> GetAllReservation() {
        return resrvationRepository.findAll();
    }

    @Override
    @Transactional
    public Reservation ajouterReservationEtAssignerAChambreEtAEtudiant(Reservation res, Long numChambre, Long cin) {

        Reservation resrvation = resrvationRepository.findById(res.getIdReservation()).orElse(null);
        resrvation.setChamber(chambreRepository.findById(numChambre).orElse(null));
       resrvation.getEtudiants().add(etudiantRepository.findEtudiantByCin(cin));
        return resrvation;

    }

    @Override
    public long getReservationParAnneeUniversitaire(Date debutAnnee, Date finAnnee) {
        List<Reservation> reservation =  resrvationRepository.findByAnneUniversitaireBetween(debutAnnee, finAnnee);
        return reservation.size();
    }


}
