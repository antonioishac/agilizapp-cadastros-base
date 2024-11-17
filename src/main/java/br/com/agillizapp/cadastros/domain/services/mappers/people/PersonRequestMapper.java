package br.com.agillizapp.cadastros.domain.services.mappers.people;

import br.com.agillizapp.cadastros.api.request.people.PersonRequest;
import br.com.agillizapp.cadastros.domain.repositories.entities.Person;
import br.com.agillizapp.cadastros.domain.services.mappers.ConverterMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { })
public interface PersonRequestMapper extends ConverterMapper<PersonRequest, Person> {
}
