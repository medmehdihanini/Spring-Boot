package tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Service.IfoyerService;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.Foyer;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("foyer")
@RestController
public class FoyerRestController {
    private final IfoyerService foyerService;
    @GetMapping("Allfoyer") //affichage
    public List<Foyer> getAllFoyer() {
        return foyerService.GetAllfoyer();
    }

    @PostMapping("addfoyer") // ajouter
    //@ResponseBody
    public Foyer AddFoyer(@RequestBody Foyer f) {
        return foyerService.Ajouterfoyer(f);
    }
    @DeleteMapping("deletefoyer/{id}")
    public void Supprimerfoyer(@PathVariable Long id) {
        foyerService.SupprimeFoyer(id);
    }
    @PutMapping("update")
    public Foyer ModifierFoyer( @RequestBody Foyer f) {
        return foyerService.Updatefoyer(f);
    }

    @GetMapping("getfoyer/{id}")
    public Foyer getfoyerByid(@PathVariable long id){
        return foyerService.Getfoyer(id);
    }




}
