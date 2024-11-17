package br.com.agillizapp.cadastros.domain.services.mappers.people;

import br.com.agillizapp.cadastros.domain.repositories.entities.Person;
import br.com.agillizapp.cadastros.domain.services.dtos.people.PersonDTO;
import br.com.agillizapp.cadastros.domain.services.mappers.ConverterMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { ContactMapper.class })
public interface PersonMapper extends ConverterMapper<PersonDTO, Person> {
}
