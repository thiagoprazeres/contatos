package info.assessoriablue.contatos.controller;

import info.assessoriablue.contatos.dto.ContatosDTO;
import info.assessoriablue.contatos.dto.MessageResponseDTO;
import info.assessoriablue.contatos.entity.Contatos;
import info.assessoriablue.contatos.repository.ContatosRepository;
import info.assessoriablue.contatos.service.ContatosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/contatos")
public class ContatosController {

    private ContatosService contatosService;

    @Autowired
    public ContatosController(ContatosService contatosService) {
        this.contatosService = contatosService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createContatos(@RequestBody @Valid ContatosDTO contatosDTO){
        return contatosService.createContatos(contatosDTO);
    }

    @GetMapping
    public String getContatos(){
        return "Hello world!!!";
    }

}
