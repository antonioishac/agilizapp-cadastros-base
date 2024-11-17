package br.com.agillizapp.cadastros.domain.services.banks;

import br.com.agillizapp.cadastros.api.request.banks.BankRequest;
import br.com.agillizapp.cadastros.domain.services.dtos.banks.BankDTO;
import br.com.agillizapp.cadastros.domain.services.dtos.PageDTO;
import br.com.agillizapp.cadastros.domain.services.filter.BankFilter;

import java.util.Map;

public interface IBankService {

    BankDTO saveBank(BankRequest request);
    PageDTO<BankDTO> findByBankFilter(BankFilter bankFilter, Integer page , Integer size );
    BankDTO updateBank(Integer id, BankRequest request);
    BankDTO findBank(Integer id);
    void removeBank(Integer id);
    BankDTO partialBankUpdate(Integer id, Map<String, Object> fields);
}
