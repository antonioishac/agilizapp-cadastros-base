package br.com.agillizapp.cadastros.domain.services.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PersonDTO {

    private Long id;

    private String name;

    private String personType;

    private String site;

    private String email;

    private String client;

    private String supplier;

    private String shippingCompany;

    private String collaborator;

    private String accountant;

    @JsonProperty("contacts")
    private List<ContactDTO> contacts;

}
