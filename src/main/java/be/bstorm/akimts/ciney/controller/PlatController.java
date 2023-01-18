package be.bstorm.akimts.ciney.controller;

import be.bstorm.akimts.ciney.fakedb.PlatFakeDB;
import be.bstorm.akimts.ciney.models.Plat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PlatController {

    private final PlatFakeDB platRepo;

    public PlatController(PlatFakeDB platRepo) {
        this.platRepo = platRepo;
    }

    // GET - http://localhost:8080/menu
    @GetMapping("/menu")
    public String displayAll(Model model){
        List<Plat> plats = platRepo.getAll();
        model.addAttribute("plats", plats);
        return "";
    }

    public String displayOne(){

    }

}
