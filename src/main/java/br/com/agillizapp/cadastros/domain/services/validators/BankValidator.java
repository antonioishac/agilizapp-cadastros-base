package br.com.agillizapp.cadastros.domain.services.validators;

import br.com.agillizapp.cadastros.api.config.handler.exception.ApiException;
import br.com.agillizapp.cadastros.api.config.handler.util.ExceptionCodeEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BankValidator {

    public void existsCodeBank(Boolean exists) {
        if (exists) {
            throw new ApiException(ExceptionCodeEnum.ERROR_NEW_BANK_CODE_EXISTS);
        }
    }

}
