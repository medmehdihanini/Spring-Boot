package tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Repository.IchambreRepository;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Service.IChambreService;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.Chambre;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("Chambre")
@RestController
public class ChambreRestController {
    private final IChambreService chambreService;
    @GetMapping("GetAllChambre")
    public List<Chambre> GetAllChambre(){return chambreService.GetAllChambres();}
    @PostMapping("Addchambre")
    public Chambre AjoutChambre(@RequestBody Chambre c){
   return chambreService.AjoutChambre(c);
    }
    @PutMapping("Update/{id}")
    public Chambre Updatechambre(@RequestBody Chambre c ){
        return chambreService.UpdateChambre(c);
    }
    @DeleteMapping("deleteChambre/{id}")
    public void SupprimerChambre(@PathVariable long id){
        chambreService.SupprimerChambre(id);
    }




}
