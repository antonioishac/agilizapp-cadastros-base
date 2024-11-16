package br.com.agillizapp.cadastros.domain.services.mappers;

import br.com.agillizapp.cadastros.api.request.PersonRequest;
import br.com.agillizapp.cadastros.domain.repositories.entities.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { })
public interface PersonRequestMapper extends ConverterMapper<PersonRequest, Person> {
}
