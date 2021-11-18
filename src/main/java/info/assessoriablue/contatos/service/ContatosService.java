package info.assessoriablue.contatos.service;

import info.assessoriablue.contatos.dto.ContatosDTO;
import info.assessoriablue.contatos.dto.MessageResponseDTO;
import info.assessoriablue.contatos.entity.Contatos;
import info.assessoriablue.contatos.mapper.ContatosMapper;
import info.assessoriablue.contatos.repository.ContatosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Service
public class ContatosService {

    private ContatosRepository contatosRepository;
    private final ContatosMapper contatosMapper = ContatosMapper.INSTANCE;


    @Autowired
    public ContatosService(ContatosRepository contatosRepository) {
        this.contatosRepository = contatosRepository;
    }

    public MessageResponseDTO createContatos(ContatosDTO contatosDTO){
        Contatos contatosToSave = contatosMapper.toModel(contatosDTO);
        Contatos savedContatos = contatosRepository.save(contatosToSave);
        return MessageResponseDTO.builder().message("Contato criado com sucesso" + savedContatos.getId()).build();
    }

}