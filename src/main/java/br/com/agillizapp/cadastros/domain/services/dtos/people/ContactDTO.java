package br.com.agillizapp.cadastros.domain.services.dtos.people;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ContactDTO {

    @JsonProperty("id")
    @Schema(name = "id", description = "id do contati", type = "int", example = "50")
    private Long id;

    @JsonProperty("name")
    @Schema(name = "name", description = "Nome do contato", type = "Nome do contato", example = "João Pires")
    private String name;

    @JsonProperty("email")
    @Schema(name = "email", description = "Descrição do email", type = "string", example = "joappires@gmail.com")
    private String email;

    @JsonProperty("observation")
    @Schema(name = "observation", description = "Observação do contato", type = "string", example = "Contato do Pai")
    private String observation;
}
