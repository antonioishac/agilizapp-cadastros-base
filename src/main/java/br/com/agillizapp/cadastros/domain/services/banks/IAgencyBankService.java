package br.com.agillizapp.cadastros.domain.services.banks;

import br.com.agillizapp.cadastros.api.request.banks.AgencyBankRequest;
import br.com.agillizapp.cadastros.domain.services.dtos.banks.AgencyBankDTO;

public interface IAgencyBankService {

    AgencyBankDTO saveBank(AgencyBankRequest request);
}
