package br.com.agillizapp.cadastros.domain.services.mappers.people;

import br.com.agillizapp.cadastros.domain.repositories.entities.Contact;
import br.com.agillizapp.cadastros.domain.services.dtos.people.ContactDTO;
import br.com.agillizapp.cadastros.domain.services.mappers.ConverterMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMapper extends ConverterMapper<ContactDTO, Contact> {

//    @Override
//    @Mapping(target = "person", ignore = true)
//    ContactDTO toDto(Contact entity);
}
