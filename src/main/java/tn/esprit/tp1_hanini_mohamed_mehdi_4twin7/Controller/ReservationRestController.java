package tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Service.IReservationService;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.Bloc;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.Reservation;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("Reservation")
@RestController
public class ReservationRestController {
    final public IReservationService reservationService;
    @GetMapping("ALLReservation")
    public List<Reservation> getAllReservation(){return reservationService.GetAllReservation();}
    @PostMapping("addReservation")
    public Reservation Addbloc(@RequestBody Reservation r){return reservationService.AjouterReservation(r);}
    @DeleteMapping("deleteReservation/{id}")
    public void Deletefoyer(@PathVariable long id){

        reservationService.SupprimerReservation(id);}

    @PutMapping("UpdateReservation/{id}")
    public Reservation MOdifierBlocs(@RequestBody Reservation r)
    {
        return reservationService.UpdateReservation(r);
    }
}

