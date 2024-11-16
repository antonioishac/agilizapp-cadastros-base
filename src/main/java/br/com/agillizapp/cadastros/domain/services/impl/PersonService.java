package br.com.agillizapp.cadastros.domain.services.impl;

import br.com.agillizapp.cadastros.api.request.PersonRequest;
import br.com.agillizapp.cadastros.domain.repositories.PersonRepository;
import br.com.agillizapp.cadastros.domain.services.IPersonService;
import br.com.agillizapp.cadastros.domain.services.dtos.PersonDTO;
import br.com.agillizapp.cadastros.domain.services.mappers.PersonMapper;
import br.com.agillizapp.cadastros.domain.services.mappers.PersonRequestMapper;
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
