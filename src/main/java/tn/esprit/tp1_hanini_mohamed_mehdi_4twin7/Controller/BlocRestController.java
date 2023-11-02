package tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Controller;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.Service.IBlocService;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.enteties.Bloc;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("Bloc")
@RestController
public class BlocRestController {
    private final IBlocService blocService;
    @GetMapping("Allblocs")
    public List<Bloc> getAllbloc(){return blocService.GetAllBlocs();}
    @PostMapping("addblocs")
public Bloc Addbloc(@RequestBody Bloc b){return blocService.AjouterBloc(b);}
    @DeleteMapping("deletebloc/{id}")
    public void Deletefoyer(@PathVariable long id){
        System.out.println("tfaskh");
        blocService.SupprimerBloc(id);}

    @PutMapping("Updatebloc")
    public Bloc MOdifierBlocs(@RequestBody Bloc b)
        {
            return blocService.UpdateBloc(b);
        }


@PutMapping("affecteChambre/{nom}")
    public Bloc affecterChambreBloc(@RequestBody List<Long>numChambre,@PathVariable String nom)
{
return blocService.affecterChambresABloc(numChambre,nom);
}



@PutMapping("assignRoomsToBlock/{blockName}")
public Bloc assignRoomsToBlock(@RequestBody List<Long> roomIds, @PathVariable String blockName) {

  return blocService.affecterChambresABloc(roomIds, blockName);

}


    @PutMapping("affecterBlocAFoyer/{nomBloc}/{nomFoyer}")
    public Bloc affecterBlocAFoyer(@PathVariable  String nomBloc, @PathVariable String nomFoyer)
    {
        return blocService.affecterBlocAFoyer(nomBloc,nomFoyer);
    }








}
