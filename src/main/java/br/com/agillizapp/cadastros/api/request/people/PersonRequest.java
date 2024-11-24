package br.com.agillizapp.cadastros.api.request.people;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PersonRequest {

    @JsonProperty("name")
    @Schema(name = "name", description = "Nome da pessoa", type = "string", example = "João Gouveia")
    private String name;

    @JsonProperty("personType")
    @Schema(name = "personType", description = "Tipo de pessoa - F: Física | J: Jurídica", type = "string", example = "F")
    private String personType;

    @JsonProperty("name")
    @Schema(name = "name", description = "Site", type = "string", example = "João Pires")
    private String site;

    @JsonProperty("name")
    @Schema(name = "name", description = "Email da pessoa", type = "string", example = "João Pires")
    private String email;

    @JsonProperty("name")
    @Schema(name = "name", description = "A pessoa é um cliente?", type = "string", example = "João Pires")
    private String client;

    @JsonProperty("name")
    @Schema(name = "name", description = "A pessoa é um fornecedor?", type = "string", example = "João Pires")
    private String supplier;

    @JsonProperty("name")
    @Schema(name = "name", description = "A pessoa é uma transportadora?", type = "string", example = "João Pires")
    private String shippingCompany;

    @JsonProperty("name")
    @Schema(name = "name", description = "A pessoa é um colaborador?", type = "string", example = "João Pires")
    private String collaborator;

    @JsonProperty("name")
    @Schema(name = "name", description = "A pessoa é um contador?", type = "string", example = "João Pires")
    private String accountant;

    @JsonProperty("contacts")
    private List<ContactRequest> contacts;

    @JsonProperty("addresses")
    private List<AddressRequest> addresses;

}
