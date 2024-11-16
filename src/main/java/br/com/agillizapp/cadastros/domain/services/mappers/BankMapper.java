package br.com.agillizapp.cadastros.domain.services.mappers;

import br.com.agillizapp.cadastros.domain.repositories.entities.BankEntity;
import br.com.agillizapp.cadastros.domain.services.dtos.BankDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BankMapper extends ConverterMapper<BankDTO, BankEntity> {
}
