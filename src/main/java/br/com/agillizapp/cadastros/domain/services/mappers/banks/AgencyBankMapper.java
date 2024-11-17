package br.com.agillizapp.cadastros.domain.services.mappers.banks;

import br.com.agillizapp.cadastros.domain.repositories.entities.AgencyBankEntity;
import br.com.agillizapp.cadastros.domain.services.dtos.banks.AgencyBankDTO;
import br.com.agillizapp.cadastros.domain.services.mappers.ConverterMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AgencyBankMapper extends ConverterMapper<AgencyBankDTO, AgencyBankEntity> {
}
