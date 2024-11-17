package br.com.agillizapp.cadastros.api.controller.banks;

import br.com.agillizapp.cadastros.api.config.handler.dto.ResponseErrorDTO;
import br.com.agillizapp.cadastros.api.request.banks.AgencyBankRequest;
import br.com.agillizapp.cadastros.api.request.banks.BankRequest;
import br.com.agillizapp.cadastros.domain.services.banks.IAgencyBankService;
import br.com.agillizapp.cadastros.domain.services.dtos.banks.AgencyBankDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/bank-agencies")
@RequiredArgsConstructor
@Tag(name = "Agências", description = "Gerenciando de Agências Bancárias.")
public class AgencyBankController {

    private final IAgencyBankService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Criação de uma nova agência bancária", description = "Agências", responses = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Bank Agency created"),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad Request",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ResponseErrorDTO.class))),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal Server Error",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ResponseErrorDTO.class)))
    })
    public ResponseEntity<AgencyBankDTO> saveBank(@Valid @RequestBody AgencyBankRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.saveBank(request));
    }
}
