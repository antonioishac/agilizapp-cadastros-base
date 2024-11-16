package br.com.agillizapp.cadastros.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BankRequest {

    @JsonProperty("code")
    @Schema(name = "code", description = "Código do banco no Bacen", example = "123")
    private String code;

    @NotNull(message = "bank.name.not.null")
    @NotEmpty(message = "bank.name.not.empty")
    @JsonProperty("name")
    @Schema(name = "name", description = "Nome do Banco", requiredMode = Schema.RequiredMode.REQUIRED, example = "Banco do Brasil")
    private String name;

    @JsonProperty("url")
    @Schema(name = "url", description = "URL do Banco", example = "https://bb.com.br")
    private String url;
}
