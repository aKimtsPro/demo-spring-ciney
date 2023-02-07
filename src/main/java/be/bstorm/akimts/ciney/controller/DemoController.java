package be.bstorm.akimts.ciney.controller;

import be.bstorm.akimts.ciney.models.GenerateNamesForm;
import be.bstorm.akimts.ciney.service.NameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DemoController {

//    @Autowired - field injection not recommanded
    private final NameService nameService;

    public DemoController(NameService nameService) {
        this.nameService = nameService;
    }

    // GET - http://localhost:8080/message
    @GetMapping("/message")
    public String displayMessage(Model model){
        String message = "mon message venant du controller";
        model.addAttribute( "msg", message );
        return "message-view";
    }

//    @GetMapping("/generate/words")
//    public String generateNames(Model model){
//
//        List<String> names = nameService.generateNames(5, 5);
//        model.addAttribute("names", names);
//        return "display-names";
//
//    }

//    @GetMapping("/generate/words")
//    public String generateNames(
//            Model model,
//            @RequestParam(value = "qtt", required = false, defaultValue = "5") int quantity,
//            @RequestParam(required = false, defaultValue = "5") int length
//    ){
//        List<String> names = nameService.generateNames(quantity, length);
//        model.addAttribute("names", names);
//        return "display-names";
//    }

    @GetMapping("/generate/words/form")
    public String displayGenerateNamesForm(Model model){
        model.addAttribute( "form", new GenerateNamesForm());
        return "generate-names-form";
    }

    @GetMapping("/generate/words")
    public String generateNames( Model model, GenerateNamesForm form ){
        List<String> names = nameService.generateNames( form.getQtt(), form.getSize() );
        model.addAttribute("names", names);
        return "display-names";
    }

}
