package tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Repository.IchambreRepository;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Service.IChambreService;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.Chambre;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.TypeChambre;

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
    @PutMapping("Update")
    public Chambre Updatechambre(@RequestBody Chambre c ){
        return chambreService.UpdateChambre(c);
    }
    @DeleteMapping("deleteChambre/{id}")
    public void SupprimerChambre(@PathVariable long id){
        chambreService.SupprimerChambre(id);
    }
 @GetMapping("getChambresParNomBloc/{nomBloc}")
    public List<Chambre> getChambresParNomBloc(@PathVariable String nomBloc){
       return chambreService.getChambresParNomBloc(nomBloc);

    }

    @GetMapping("nbChambreParTypeEtBloc/{type}/{idbloc}")
    public long nbChambreParTypeEtBloc(@PathVariable TypeChambre type,@PathVariable long idbloc){
       return chambreService.nbChambreParTypeEtBloc(type,idbloc);

    }

    @GetMapping("getChambresNonReserveParNomFoyerEtTypeChambre/{nomFoyer}/{type}")
    public List<Chambre> getChambresNonReserveParNomFoyerEtTypeChambre(@PathVariable String nomFoyer, @PathVariable TypeChambre type){
       return chambreService.getChambresNonReserveParNomFoyerEtTypeChambre(nomFoyer,type);

    }




}
