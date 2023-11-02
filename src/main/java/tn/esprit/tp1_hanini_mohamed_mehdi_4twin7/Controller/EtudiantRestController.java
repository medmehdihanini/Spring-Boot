package tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Service.IEtudiantService;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.Etudiant;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("Etudiant")
@RestController

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



















}
