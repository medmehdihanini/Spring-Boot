package tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Service.IEtudiantService;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.Etudiant;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("Etudiant")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EtudiantRestController {
    private final IEtudiantService etudiantService;
    @GetMapping("Alletudiant")
    public List<Etudiant> GetAlletudnat(){return etudiantService.GetAllEtudiant();}
    @PostMapping("AddEtudiant")
    public Etudiant AddEtudiant(@RequestBody Etudiant e){
        return etudiantService.AjouterEtudiant(e);
    }
    @PutMapping("UpdateEtudiant")
    public Etudiant UpdateEtudiant(@RequestBody Etudiant e){
        return etudiantService.UpdateEtudiant(e);
    }
    @DeleteMapping("delete/{id}")
    public void SupprimerChambre(@PathVariable long id){
        etudiantService.SupprimerEtdiant(id);}



    @PostMapping("AddEtudiantapi")
    public Boolean AddEtudiantAPI(@RequestBody Etudiant e){
        return etudiantService.AjouterEtudiantAPI(e);
    }

    @PostMapping("login")
    public Etudiant loginetudiant(@RequestBody Etudiant e){
        return etudiantService.loginetudiant(e.getEmail(),e.getPassoword());
    }


    @GetMapping("one/{id}")
    public Etudiant getEtudiant(@PathVariable long id){
        return etudiantService.getEtudiant(id);
    }

    @GetMapping("blocked/{id}")
    public Etudiant etudiantBlocked(@PathVariable long id){
        return etudiantService.etudiantBlocked(id);
    }


    @PostMapping("offline/{id}")
    public Etudiant etatOflline(@PathVariable long id){
        return etudiantService.etatOflline(id);
    }
















}
