package br.com.agillizapp.cadastros.domain.services.people;

import br.com.agillizapp.cadastros.api.request.people.PersonRequest;
import br.com.agillizapp.cadastros.domain.services.dtos.people.PersonDTO;

public interface IPersonService {

    PersonDTO savePerson(PersonRequest request);

}
