package br.com.agillizapp.cadastros.domain.services.dtos.people;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PersonDTO {

    @JsonProperty("id")
    @Schema(name = "id", description = "id", type = "Nome da pessoa", example = "Juliano do carmo Almeida")
    private Long id;

    @JsonProperty("name")
    @Schema(name = "name", description = "name", type = "string", example = "Rua do carmo")
    private String name;

    @JsonProperty("personType")
    @Schema(name = "personType", description = "Tipo de pessoa - F: Física | J: Jurídica", type = "string", example = "F")
    private String personType;

    @JsonProperty("site")
    @Schema(name = "site", description = "site", type = "string", example = "https://sitedapessoa.com")
    private String site;

    @JsonProperty("email")
    @Schema(name = "email", description = "email", type = "Descrição do e-mail", example = "emaildapessoa@server.com")
    private String email;

    @JsonProperty("client")
    @Schema(name = "client", description = "A pessoa é um cliente?", type = "string", example = "S")
    private String client;

    @JsonProperty("supplier")
    @Schema(name = "supplier", description = "A pessoa é um fornecedor?", type = "string", example = "S")
    private String supplier;

    @JsonProperty("shippingCompany")
    @Schema(name = "shippingCompany", description = "A pessoa é uma trasnportadora?", type = "string", example = "N")
    private String shippingCompany;

    @JsonProperty("collaborator")
    @Schema(name = "collaborator", description = "A pessoa é um colaborador:", type = "string", example = "N")
    private String collaborator;

    @JsonProperty("accountant")
    @Schema(name = "accountant", description = "A pessoa é um contador?", type = "string", example = "N")
    private String accountant;

    @JsonProperty("contacts")
    private List<ContactDTO> contacts;

    @JsonProperty("addresses")
    private List<AddressDTO> addresses;

}
