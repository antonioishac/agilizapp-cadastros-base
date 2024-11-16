package br.com.agillizapp.cadastros.domain.services.mappers;

import br.com.agillizapp.cadastros.domain.repositories.entities.Person;
import br.com.agillizapp.cadastros.domain.services.dtos.PersonDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { ContactMapper.class })
public interface PersonMapper extends ConverterMapper<PersonDTO, Person> {
}
