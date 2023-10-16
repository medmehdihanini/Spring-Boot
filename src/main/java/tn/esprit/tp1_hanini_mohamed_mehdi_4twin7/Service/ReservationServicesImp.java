package tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Repository.IresrvationRepository;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.Reservation;

import java.util.List;
@Service
@AllArgsConstructor
public class ReservationServicesImp implements IReservationService{
    IresrvationRepository resrvationRepository;
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
}
