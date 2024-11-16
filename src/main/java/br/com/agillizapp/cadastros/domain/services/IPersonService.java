package br.com.agillizapp.cadastros.domain.services;

import br.com.agillizapp.cadastros.api.request.PersonRequest;
import br.com.agillizapp.cadastros.domain.services.dtos.PersonDTO;

public interface IPersonService {

    PersonDTO savePerson(PersonRequest request);

}
