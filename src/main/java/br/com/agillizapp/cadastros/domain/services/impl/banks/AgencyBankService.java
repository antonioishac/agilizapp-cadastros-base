package br.com.agillizapp.cadastros.domain.services.impl.banks;

import br.com.agillizapp.cadastros.api.request.banks.AgencyBankRequest;
import br.com.agillizapp.cadastros.domain.repositories.AgencyBankRepository;
import br.com.agillizapp.cadastros.domain.repositories.BankRepository;
import br.com.agillizapp.cadastros.domain.services.banks.IAgencyBankService;
import br.com.agillizapp.cadastros.domain.services.dtos.banks.AgencyBankDTO;
import br.com.agillizapp.cadastros.domain.services.mappers.banks.AgencyBankMapper;
import br.com.agillizapp.cadastros.domain.services.mappers.banks.AgencyBankRequestMapper;
import br.com.agillizapp.cadastros.domain.services.validators.AgencyBankValidator;
import br.com.agillizapp.cadastros.domain.services.validators.BankValidator;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AgencyBankService implements IAgencyBankService {

    private final AgencyBankRepository repository;
    private final BankRepository bankRepository;
    private final BankValidator bankValidator;
    private final AgencyBankValidator agencyValidator;
    private final AgencyBankRequestMapper requestMapper;
    private final AgencyBankMapper mapper;

    @Override
    public AgencyBankDTO saveBank(AgencyBankRequest request) {

        agencyValidator.existsCodeAgencyBank(
                repository.findAgencyBankByCode(request.getCode()).isPresent());

        var bank = bankRepository.findBankByCode(request.getCodeBank());
        bankValidator.notExistCodeBank(bank.isPresent());

        var agencyBank = requestMapper.toEntity(request);
        bank.ifPresent(agencyBank::setBank);
        agencyBank.setZipCode(agencyBank.getZipCode().replaceAll("\\D", StringUtils.EMPTY));

        repository.save(agencyBank);

        return mapper.toDto(agencyBank);
    }

}
