package info.assessoriablue.contatos;

import info.assessoriablue.contatos.dto.MessageResponseDTO;
import info.assessoriablue.contatos.entity.Contatos;
import info.assessoriablue.contatos.repository.ContatosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Service
public class ContatosService {

    private ContatosService contatosService;

    @Autowired
    public ContatosService(ContatosRepository contatosRepository) {
        this.contatosService = contatosService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createContatos(@RequestBody Contatos contatos){
        return contatosService.createContatos(contatos);
    }

}
