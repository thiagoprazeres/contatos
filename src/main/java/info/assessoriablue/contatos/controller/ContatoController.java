package info.assessoriablue.contatos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/contato")
public class ContatoController {

    @GetMapping
    public String getContato(){
        return "Hello world!";
    }

}
