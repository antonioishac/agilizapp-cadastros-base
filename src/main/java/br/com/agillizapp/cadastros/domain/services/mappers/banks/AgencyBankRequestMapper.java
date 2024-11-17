package br.com.agillizapp.cadastros.domain.services.mappers.banks;

import br.com.agillizapp.cadastros.api.request.banks.AgencyBankRequest;
import br.com.agillizapp.cadastros.domain.repositories.entities.AgencyBankEntity;
import br.com.agillizapp.cadastros.domain.services.mappers.ConverterMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AgencyBankRequestMapper extends ConverterMapper<AgencyBankRequest, AgencyBankEntity> {
}
