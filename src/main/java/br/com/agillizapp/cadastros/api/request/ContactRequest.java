package br.com.agillizapp.cadastros.api.request;

import br.com.agillizapp.cadastros.domain.services.dtos.PersonDTO;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ContactRequest {

    private String name;

    private String email;

    private String observation;
}
