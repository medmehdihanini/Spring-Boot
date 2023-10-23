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

    @GetMapping("All") //affichage
    public List<Foyer> getAllFoyer() {
        return foyerService.GetAllfoyer();
    }

    @PostMapping("/add") // ajouter
    //@ResponseBody
    public Foyer AddFoyer(@RequestBody Foyer f) {
        return foyerService.Ajouterfoyer(f);
    }
}
