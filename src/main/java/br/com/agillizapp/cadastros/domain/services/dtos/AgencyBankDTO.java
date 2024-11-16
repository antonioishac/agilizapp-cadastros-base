package br.com.agillizapp.cadastros.domain.services.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

public class AgencyBankDTO {

    @JsonProperty("id")
    @Schema(name = "id", description = "Código único da agencia", type = "int", example = "1")
    private Integer id;
    private BankDTO bank;

    @JsonProperty("code")
    @Schema(name = "code", description = "Código interno da agencia", type = "int", example = "123")
    private Integer code;

    @JsonProperty("name")
    @Schema(name = "name", description = "Nome da agencia bancária", requiredMode = Schema.RequiredMode.REQUIRED, example = "Agencia central")
    private String name;

    @JsonProperty("publicPlace")
    @Schema(name = "publicPlace", description = "Logradouro", requiredMode = Schema.RequiredMode.REQUIRED, example = "Rua tal")
    private String publicPlace;

    @JsonProperty("number")
    @Schema(name = "number", description = "Número", requiredMode = Schema.RequiredMode.REQUIRED, example = "915")
    private String number;

    @JsonProperty("zipCode")
    @Schema(name = "zipCode", description = "CEP", requiredMode = Schema.RequiredMode.REQUIRED, example = "06412-140")
    private String zipCode;

    @JsonProperty("County")
    @Schema(name = "County", description = "Municipio IBGE", example = "3550308")
    private String County;

    @JsonProperty("state")
    @Schema(name = "state", description = "UF", requiredMode = Schema.RequiredMode.REQUIRED, example = "SP")
    private String state;

    @JsonProperty("phoneNumber")
    @Schema(name = "phoneNumber", description = "Telefone", requiredMode = Schema.RequiredMode.REQUIRED, example = "11971774587")
    private String phoneNumber;

    @JsonProperty("manager")
    @Schema(name = "manager", description = "Gerente", requiredMode = Schema.RequiredMode.REQUIRED, example = "Paulo Almeida")
    private String manager;

    @JsonProperty("contact")
    @Schema(name = "contact", description = "Contato", example = "Paulo Almeida")
    private String contact;

    @JsonProperty("observation")
    @Schema(name = "observation", description = "Observação", example = "Perto da igreja São José")
    private String observation;
}