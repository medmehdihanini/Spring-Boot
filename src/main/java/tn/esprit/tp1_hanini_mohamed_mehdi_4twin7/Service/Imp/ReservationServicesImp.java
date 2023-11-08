package tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Service.Imp;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Repository.IblocRepository;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Repository.IchambreRepository;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Repository.IetudiantRepository;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Repository.IresrvationRepository;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Service.IReservationService;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.Chambre;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.Etudiant;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.Reservation;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.TypeChambre;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
@Service
@AllArgsConstructor
public class ReservationServicesImp implements IReservationService {
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
        Chambre ch=chambreRepository.findById(numChambre).orElse(null);
        if(ch.getReservations()==null){
            ch.setReservations(new HashSet<>());
        }
        ch.getReservations().add(resrvation);
        resrvation.getEtudiants().add(etudiantRepository.findEtudiantByCin(cin));
        return resrvation;

    }

    @Override
    public Reservation ajouterReservation(long idChambre, long cinEtudiant) {
        Chambre ch = chambreRepository.findById(idChambre).orElse(null);
        Etudiant et = etudiantRepository.findEtudiantByCin(cinEtudiant);
        Reservation r = new Reservation();
        r.setNumReservation(ch.getNumchambre()+"-"+ch.getBloc2().getNomBloc()+"-"+cinEtudiant);
        r.setDebUniversitaire(LocalDate.parse(LocalDate.now().getYear() + "-09-01"));
        r.setFinUniversitaire(LocalDate.parse((LocalDate.now().getYear() + 1) + "-06-01"));
        r.setEstvalide(true);
        int c=ch.getReservations().size();
        if(r.getEtudiants()==null){
            r.setEtudiants(new HashSet<>());
        }
        if(ch.getReservations()==null){
            ch.setReservations(new HashSet<>());
        }
        if(ch.getTypeChambre()==TypeChambre.SIMPLE && c<1 ){
            r=resrvationRepository.save(r);
            ch.getReservations().add(r);
            r.getEtudiants().add(et);

            chambreRepository.save(ch);
            return r;

        }

        if(ch.getTypeChambre()==TypeChambre.DOUBLE && c<2 ){
            r=resrvationRepository.save(r);
            ch.getReservations().add(r);
            r.getEtudiants().add(et);

            chambreRepository.save(ch);
            return r;


        }
        if(ch.getTypeChambre()==TypeChambre.TRIPLE && c<3 ){
            r=resrvationRepository.save(r);
            ch.getReservations().add(r);
            r.getEtudiants().add(et);

            chambreRepository.save(ch);
            return r;

        }

        return null;
    }
@Transactional
    @Override
    public Reservation annulerReservation(long cinEtudiant) {
        Etudiant e =etudiantRepository.findEtudiantByCin(cinEtudiant);
        List<Reservation> r = resrvationRepository.findByEtudiants(e);
        for(Reservation re:r) {
            Chambre ch = chambreRepository.findChambreByReservations(re);
            ch.getReservations().remove(re);
            re.getEtudiants().remove(e);
            re.setEstvalide(false);
            resrvationRepository.save(re);
        }


return null;
    }













































































}
