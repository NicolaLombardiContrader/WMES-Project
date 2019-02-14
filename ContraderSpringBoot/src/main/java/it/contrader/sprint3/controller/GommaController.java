package it.contrader.sprint3.controller;

import it.contrader.sprint3.model.GommaEntity;
import it.contrader.sprint3.service.GommaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/gomme")
public class GommaController {

    private GommaService gommaService;

    @Autowired
    public GommaController (GommaService gommaService) {
        this.gommaService = gommaService;
    }


    @RequestMapping(value="/trelleborg", method = RequestMethod.GET)
    public String gommeByTrelleborg (Model model) {
        List<GommaEntity> gommeByTrelleborg = gommaService.findByManufacturer("trelleborg");
        model.addAttribute("gommeByTrelleborg", gommeByTrelleborg);
        return "gommeByTrelleborg";
    }

}