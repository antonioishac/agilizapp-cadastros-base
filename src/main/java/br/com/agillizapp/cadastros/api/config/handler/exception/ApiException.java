package br.com.agillizapp.cadastros.api.config.handler.exception;

import br.com.agillizapp.cadastros.api.config.handler.util.ExceptionCodeEnum;
import lombok.Getter;

public class ApiException extends RuntimeException {

    private static final long serialVersionUID = 5127042490049753890L;

    @Getter
    private final ExceptionCodeEnum exceptionCodeEnum;

    public ApiException(final ExceptionCodeEnum exceptionCodeEnum, final Throwable e) {
        super(e);
        this.exceptionCodeEnum = exceptionCodeEnum;
    }

    public ApiException(final ExceptionCodeEnum exceptionCodeEnum) {
        this(exceptionCodeEnum, null);
    }

}

