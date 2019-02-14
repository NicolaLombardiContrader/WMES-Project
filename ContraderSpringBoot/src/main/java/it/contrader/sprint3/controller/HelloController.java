package it.contrader.sprint3.controller;

import it.contrader.sprint3.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;



@Controller
public class HelloController {

    private HelloService helloService;

    @Autowired
    public HelloController (HelloService helloService) {
        this.helloService =helloService;
    }

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String hello (Map<String, Object> model) {
        model.put("saluto", "Ciao Mondo!");
        model.put("face", ":(");
        return "hello";
    }

    @RequestMapping(value="/happy", method = RequestMethod.POST)
    public String happyFace(Map<String, Object> model) {
        String string = helloService.setHappyFace();
        model.put("saluto", "Ciao Mondo!");
        model.put("face", string);
        return "hello";
    }

}
