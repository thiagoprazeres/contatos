package info.assessoriablue.contatos.controller;

import info.assessoriablue.contatos.dto.ContatosDTO;
import info.assessoriablue.contatos.dto.MessageResponseDTO;
import info.assessoriablue.contatos.entity.Contatos;
import info.assessoriablue.contatos.excepttion.ContatosNotFoundException;
import info.assessoriablue.contatos.repository.ContatosRepository;
import info.assessoriablue.contatos.service.ContatosService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/contatos")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ContatosController {

    private ContatosService contatosService;

    @CrossOrigin
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createContatos(@RequestBody @Valid ContatosDTO contatosDTO){
        return contatosService.createContatos(contatosDTO);
    }

    @CrossOrigin
    @GetMapping
    public List<ContatosDTO> listAll(){
        return contatosService.listAll();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ContatosDTO findById(@PathVariable Long id) throws ContatosNotFoundException{
        return contatosService.findById(id);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid ContatosDTO contatosDTO) throws ContatosNotFoundException {
        return contatosService.updateById(id, contatosDTO);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws ContatosNotFoundException {
        contatosService.deleteById(id);
    }
}
