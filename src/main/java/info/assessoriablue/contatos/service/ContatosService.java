package info.assessoriablue.contatos.service;

import info.assessoriablue.contatos.dto.ContatosDTO;
import info.assessoriablue.contatos.dto.MessageResponseDTO;
import info.assessoriablue.contatos.entity.Contatos;
import info.assessoriablue.contatos.excepttion.ContatosNotFoundException;
import info.assessoriablue.contatos.mapper.ContatosMapper;
import info.assessoriablue.contatos.repository.ContatosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContatosService {

    private ContatosRepository contatosRepository;
    private final ContatosMapper contatosMapper = ContatosMapper.INSTANCE;


    @Autowired
    public ContatosService(ContatosRepository contatosRepository) {
        this.contatosRepository = contatosRepository;
    }

    public MessageResponseDTO createContatos(ContatosDTO contatosDTO){
        Contatos contatosToSave = Contatos.builder()
                .nome(contatosDTO.getNome())
                .email(contatosDTO.getEmail())
                .telefone(contatosDTO.getTelefone())
                .build();
        Contatos savedContatos = contatosRepository.save(contatosToSave);
        return MessageResponseDTO.builder().message("Contato criado com sucesso" + savedContatos.getId()).build();
    }

    public List<ContatosDTO> listAll() {
        List<Contatos> allContatos = contatosRepository.findAll();
        return allContatos.stream()
                .map(contatosMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ContatosDTO findById(Long id) throws ContatosNotFoundException {
        Contatos contatos = contatosRepository.findById(id)
                .orElseThrow(() ->new ContatosNotFoundException(id));
        return contatosMapper.toDTO(contatos);

    }

    public void deleteById(Long id) throws ContatosNotFoundException {
        verifyIfExists(id);
        contatosRepository.deleteById(id);
    }

    private Contatos verifyIfExists(Long id) throws ContatosNotFoundException {
        return contatosRepository.findById(id)
                .orElseThrow(() ->new ContatosNotFoundException(id));
    }

}
