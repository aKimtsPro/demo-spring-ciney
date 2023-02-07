package be.bstorm.akimts.ciney.controller;

import be.bstorm.akimts.ciney.models.PlatUpdateForm;
import be.bstorm.akimts.ciney.service.PlatService;
import be.bstorm.akimts.ciney.service.impl.PlatServiceMock;
import be.bstorm.akimts.ciney.models.Plat;
import be.bstorm.akimts.ciney.models.PlatCreateForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PlatController {

    private final PlatService platService;

    /**
     *   1 - PlatController doit produire un Bean
     *   2 - PlatFakeDB doit produire un Bean
     *   3 - la dépendence doit être déclarée
     */

    public PlatController(PlatService platService) {
        this.platService = platService;
    }

    // GET - http://localhost:8080/menu
    @GetMapping("/menu")
    public String displayAll(Model model){
        List<Plat> plats = platService.getAll();
        model.addAttribute("plats", plats);
        return "plat/all";
    }

    // GET - http://localhost:8080/plat/9?param=value
    @GetMapping("/plat/{id:[0-9]+}")
    public String displayOne(Model model, @PathVariable("id") long id){
        Plat plat = platService.getOne( id );
        model.addAttribute( "plat", plat );
        return "plat/one";
    }

    @GetMapping("/plat/create")
    public String displayCreateForm(Model model){
        model.addAttribute("form", new PlatCreateForm());
        return "plat/create-form";
    }

    @PostMapping("/plat/create")
    public String processCreateForm(PlatCreateForm form){
        platService.create( form );
        return "redirect:/menu";
    }

    // TODO continuer le update
    @GetMapping("/plat/{id:[0-9]+}/update")
    public String displayUpdateForm(Model model, @PathVariable int id){
        Plat plat = platService.getOne(id);

        PlatUpdateForm form = new PlatUpdateForm(); // rempli des valeurs du plat
        form.setNom( plat.getNom() );
        form.setPrix( plat.getPrix() );
        form.setDispo( plat.isDispo() );

        model.addAttribute("form", form);
        model.addAttribute("id", id);

        return "plat/update-form";
    }

    @PostMapping("/plat/{id:[0-9+]}/update")
    public String processUpdate(@PathVariable long id,PlatUpdateForm form){
        platService.update(id, form);
        return "redirect:/plat/"+id;
    }

}
