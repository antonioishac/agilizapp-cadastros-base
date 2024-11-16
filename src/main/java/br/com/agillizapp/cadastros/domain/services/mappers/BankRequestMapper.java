package br.com.agillizapp.cadastros.domain.services.mappers;

import br.com.agillizapp.cadastros.api.request.BankRequest;
import br.com.agillizapp.cadastros.domain.repositories.entities.BankEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BankRequestMapper extends ConverterMapper<BankRequest, BankEntity> {
}
