package br.com.agillizapp.cadastros.domain.services.impl.people;

import br.com.agillizapp.cadastros.api.request.people.PersonRequest;
import br.com.agillizapp.cadastros.domain.repositories.PersonRepository;
import br.com.agillizapp.cadastros.domain.services.people.IPersonService;
import br.com.agillizapp.cadastros.domain.services.dtos.people.PersonDTO;
import br.com.agillizapp.cadastros.domain.services.mappers.people.PersonMapper;
import br.com.agillizapp.cadastros.domain.services.mappers.people.PersonRequestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService implements IPersonService {

    private final PersonRepository repository;
    private final PersonRequestMapper personRequestMapper;
    private final PersonMapper mapper;

    @Override
    public PersonDTO savePerson(PersonRequest request) {

        var personEntity = personRequestMapper.toEntity(request);
        var personEntitySave = repository.save(personEntity);
        return mapper.toDto(personEntitySave);
    }
}
