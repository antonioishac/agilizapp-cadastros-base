package br.com.agillizapp.cadastros.domain.services.filter;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BankFilter {

    @Schema(name = "name", description = "Nome do Banco.", example = "Banco do Brasil")
    private String name;

    @Schema(name = "code", description = "Codigo do banco no Bacen", example = "123")
    private String code;
}
