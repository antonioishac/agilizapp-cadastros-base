package br.com.agillizapp.cadastros.api.controller;

import br.com.agillizapp.cadastros.api.request.PersonRequest;
import br.com.agillizapp.cadastros.domain.services.IPersonService;
import br.com.agillizapp.cadastros.domain.services.dtos.PersonDTO;
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
@RequestMapping("/v1/people")
@RequiredArgsConstructor
@Tag(name = "Pessoas", description = "Manutenção de pessoas.")

public class PersonController {

    private final IPersonService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Criação de uma nova pessoa", description = "pessoas", responses = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Person created"),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad Request",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Error.class))),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal Server Error",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = PersonRequest.class)))
    })
    public ResponseEntity<PersonDTO> saveCustomer(@Valid @RequestBody PersonRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.savePerson(request));
    }

}
