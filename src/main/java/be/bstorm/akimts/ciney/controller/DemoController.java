package be.bstorm.akimts.ciney.controller;

import be.bstorm.akimts.ciney.fakedb.PlatFakeDB;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {


    // GET - http://localhost:8080/message
    @GetMapping("/message")
    public String displayMessage(Model model){
        String message = "mon message venant du controller";
        model.addAttribute( "msg", message );
        return "message-view";
    }

}
