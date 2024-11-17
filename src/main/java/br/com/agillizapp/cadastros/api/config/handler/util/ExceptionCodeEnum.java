package br.com.agillizapp.cadastros.api.config.handler.util;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ExceptionCodeEnum {

    // BANK
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR),
    ERROR_NEW_BANK_CODE_EXISTS(HttpStatus.BAD_REQUEST),
    ERROR_CODE_BANK_NOT_EXISTS(HttpStatus.BAD_REQUEST),
    ERROR_ID_BANK_NOT_FOUND(HttpStatus.BAD_REQUEST),

    //AgencyBank
    ERROR_NEW_AGENCY_BANK_CODE_EXISTS(HttpStatus.BAD_REQUEST);

    private final HttpStatus httpStatus;

    ExceptionCodeEnum(final HttpStatus httpStatus ) {
        this.httpStatus = httpStatus;
    }

    public String getCode() {
        return this.name();
    }

}

