package br.com.agillizapp.cadastros.api.controller;

import br.com.agillizapp.cadastros.api.config.handler.dto.ResponseErrorDTO;
import br.com.agillizapp.cadastros.api.request.BankRequest;
import br.com.agillizapp.cadastros.domain.services.IBankService;
import br.com.agillizapp.cadastros.domain.services.dtos.BankDTO;
import br.com.agillizapp.cadastros.domain.services.dtos.PageDTO;
import br.com.agillizapp.cadastros.domain.services.filter.BankFilter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/v1/banks")
@RequiredArgsConstructor
@Tag(name = "Bancos", description = "Gerenciando os Bancos.")
public class BankController {

    private final IBankService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Criação de um novo banco", description = "Bancos", responses = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Bank created"),
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
    public ResponseEntity<BankDTO> saveBank(@Valid @RequestBody BankRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.saveBank(request));
    }

    @Operation(summary = "Buscando bancos.", description = "Bancos",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Bank list"),
                    @ApiResponse(
                            responseCode = "204",
                            description = "List bank empty returned",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
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
    @GetMapping
    public ResponseEntity<PageDTO<BankDTO>> findByBankFilter(
            BankFilter customerFilter,
            @Parameter(description = "Número inicial da página.", example = "0") Integer page,
            @Parameter(description = "Qtde de páginas.", example = "10") Integer size) {

        PageDTO<BankDTO> customerDTO =
                service.findByBankFilter(customerFilter, page, size);

        return ResponseEntity.status(CollectionUtils.isEmpty(customerDTO.getContent())
                ? HttpStatus.NO_CONTENT : HttpStatus.OK).body(customerDTO);
    }

    @Operation(summary = "Atualizar Banco", description = "Bancos",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Bank updated"),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid body field",
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
    @PutMapping("/{id}")
    public ResponseEntity<BankDTO> update(
            @PathVariable("id") @Parameter(description = "Id do banco.", example = "1") Integer id,
            @Valid @RequestBody BankRequest request) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.updateBank(id, request));
    }

    @Operation(summary = "Buscar Banco pelo id", description = "Bancos",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Bank search"),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid id field",
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
    @GetMapping("/{id}")
    public ResponseEntity<BankDTO> getBank(
            @PathVariable("id") @Parameter(description = "Id do Banco.", example = "1") Integer id) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.findBank(id));
    }

    @Operation(summary = "Remover Banco pelo id", description = "Bancos",
            responses = {
                    @ApiResponse(
                            responseCode = "204",
                            description = "No Content"),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid id field",
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
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeBank(
            @PathVariable("id") @Parameter(description = "Id do Banco.", example = "1") Integer id) {

        service.removeBank(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> partialBankUpdate(
            @PathVariable("id") @Parameter(description = "Id do Banco", example = "1") Integer id,
            @RequestBody Map<String, Object> fields) {

        var bank = service.partialBankUpdate(id, fields);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
}
