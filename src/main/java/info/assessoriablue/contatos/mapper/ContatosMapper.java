package info.assessoriablue.contatos.mapper;

import info.assessoriablue.contatos.dto.ContatosDTO;
import info.assessoriablue.contatos.entity.Contatos;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContatosMapper {

    ContatosMapper INSTANCE = Mappers.getMapper(ContatosMapper.class);

    @Mapping(target = "nome")
    ContatosDTO toDTO(Contatos contatos);

    Contatos toModel(ContatosDTO contatosDTO);

}
