package tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Service.IUniversiteService;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.Foyer;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.Universite;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("Universite")
@RestController
public class UniversiteRestController {
    final public IUniversiteService universiteService;
    @GetMapping("AllUniversite") //affichage
    public List<Universite> getAllUniversite() {
        return universiteService.GetAllUuniversite();
    }

    @PostMapping("addUniversite") // ajouter
    //@ResponseBody
    public Universite AddUniversite(@RequestBody Universite u) {
        return universiteService.AjouterUniversite(u);
    }
    @DeleteMapping("deleteUniversite/{id}")
    public void SupprimerUniversite(@PathVariable Long id) {
        universiteService.SupprimerUniversite(id);
    }
    @PutMapping("update/{id}")
    public Universite ModifierUniversite( @RequestBody Universite u) {
        return universiteService.UpdateUniversite(u);
    }

}
