package it.contrader.sprint3.service;

import it.contrader.sprint3.dao.GommaRepository;
import it.contrader.sprint3.model.GommaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelloService {

    @Autowired
    public HelloService() {

    }

    public String setHappyFace () {
        return ":)";
    }
}
