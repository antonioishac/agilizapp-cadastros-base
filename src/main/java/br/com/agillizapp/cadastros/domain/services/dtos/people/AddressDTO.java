package br.com.agillizapp.cadastros.domain.services.dtos.people;

import br.com.agillizapp.cadastros.domain.repositories.entities.Person;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

public class AddressDTO {

    @JsonProperty("id")
    @Schema(name = "id", description = "Código único do banco", type = "int", example = "1")
    private Long id;

    private PersonDTO person;

    @JsonProperty("publicPlace")
    @Schema(name = "publicPlace", description = "Logradouro", type = "string", example = "Rua do carmo")
    private String publicPlace;

    @JsonProperty("streetNumber")
    @Schema(name = "streetNumber", description = "Número do logradouro", type = "string", example = "120")
    private String streetNumber;

    @JsonProperty("neighborhood")
    @Schema(name = "neighborhood", description = "Nome do bairro", type = "string", example = "Bairro da zona sul")
    private String neighborhood;

    @JsonProperty("municipalityIbge")
    @Schema(name = "municipalityIbge", description = "Código IBGE", type = "int", example = "123456")
    private int municipalityIbge;

    @JsonProperty("uf")
    @Schema(name = "uf", description = "Unidade federativa", type = "string", example = "SP")
    private String uf;

    @JsonProperty("cep")
    @Schema(name = "cep", description = "CEP da cidade", type = "string", example = "02589652")
    private String cep;

    @JsonProperty("city")
    @Schema(name = "city", description = "Nome da cidade.", type = "string", example = "Conchas")
    private String city;

    @JsonProperty("complement")
    @Schema(name = "complement", description = "Complemento", type = "string", example = "Casa dos fundos")
    private String complement;

    @JsonProperty("principal")
    @Schema(name = "principal", description = "Endereço principal.", type = "string", example = "S")
    private String principal;

    @JsonProperty("deliveryAddress")
    @Schema(name = "deliveryAddress", description = "Endereço de entrega.", type = "string", example = "S")
    private String deliveryAddress;

    @JsonProperty("billingAddress")
    @Schema(name = "billingAddress", description = "Endereço de cobrança.", type = "string", example = "S")
    private String billingAddress;

    @JsonProperty("mailingAddress")
    @Schema(name = "mailingAddress", description = "Endereço de correspondência.", type = "string", example = "S")
    private String mailingAddress;

}
