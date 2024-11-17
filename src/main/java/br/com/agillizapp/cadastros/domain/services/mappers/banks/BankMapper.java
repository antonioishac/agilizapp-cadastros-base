package br.com.agillizapp.cadastros.domain.services.mappers.banks;

import br.com.agillizapp.cadastros.domain.repositories.entities.BankEntity;
import br.com.agillizapp.cadastros.domain.services.dtos.banks.BankDTO;
import br.com.agillizapp.cadastros.domain.services.mappers.ConverterMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BankMapper extends ConverterMapper<BankDTO, BankEntity> {
}
