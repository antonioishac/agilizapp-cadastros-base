package br.com.agillizapp.cadastros.domain.repositories.custom;

import br.com.agillizapp.cadastros.domain.repositories.entities.BankEntity;
import br.com.agillizapp.cadastros.domain.services.filter.BankFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BankCustomRepository {
    Page<BankEntity> findByBankFilter(BankFilter filter, Pageable sortedByName );
}
