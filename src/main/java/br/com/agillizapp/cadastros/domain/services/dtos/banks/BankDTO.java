package br.com.agillizapp.cadastros.domain.services.dtos.banks;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BankDTO {

    @JsonProperty("id")
    @Schema(name = "id", description = "Código único do banco", type = "int", example = "1")
    private Integer id;

    @JsonProperty("code")
    @Schema(name = "code", description = "Código do banco no Bacen", example = "123")
    private String code;

    @JsonProperty("name")
    @Schema(name = "name", description = "Nome do Banco", requiredMode = Schema.RequiredMode.REQUIRED, example = "Banco do Brasil")
    private String name;

    @JsonProperty("url")
    @Schema(name = "url", description = "URL do Banco", example = "https://bb.com.br")
    private String url;
}
