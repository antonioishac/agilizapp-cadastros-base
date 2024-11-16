package br.com.agillizapp.cadastros.domain.services.mappers;

import br.com.agillizapp.cadastros.domain.repositories.entities.Contact;
import br.com.agillizapp.cadastros.domain.services.dtos.ContactDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ContactMapper extends ConverterMapper<ContactDTO, Contact>{

//    @Override
//    @Mapping(target = "person", ignore = true)
//    ContactDTO toDto(Contact entity);
}
