package br.com.agillizapp.cadastros.api.request.people;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ContactRequest {

    @JsonProperty("name")
    @Schema(name = "name", description = "Nome do contato", type = "string", example = "João Pires")
    private String name;

    @JsonProperty("email")
    @Schema(name = "email", description = "Descrição do email", type = "string", example = "joappires@gmail.com")
    private String email;

    @JsonProperty("observation")
    @Schema(name = "observation", description = "Observação do contato", type = "string", example = "Contato do Pai")
    private String observation;
}
