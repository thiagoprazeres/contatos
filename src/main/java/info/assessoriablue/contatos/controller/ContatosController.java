package info.assessoriablue.contatos.controller;

import info.assessoriablue.contatos.dto.MessageResponseDTO;
import info.assessoriablue.contatos.entity.Contatos;
import info.assessoriablue.contatos.repository.ContatosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/contatos")
public class ContatosController {

    private ContatosRepository contatosRepository;

    @Autowired
    public ContatosController(ContatosRepository contatosRepository) {
        this.contatosRepository = contatosRepository;
    }

    @PostMapping
    public MessageResponseDTO createContatos(@RequestBody Contatos contatos){
        Contatos savedContatos = contatosRepository.save(contatos);
        return MessageResponseDTO.builder()
                .message("Contato criado com sucesso com ID " + savedContatos.getId())
                .build();
    }

    @GetMapping
    public String getContatos(){
        return "Hello world!!!";
    }

}
