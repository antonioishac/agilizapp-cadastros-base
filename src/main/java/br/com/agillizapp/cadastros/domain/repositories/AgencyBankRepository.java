package br.com.agillizapp.cadastros.domain.repositories;

import br.com.agillizapp.cadastros.domain.repositories.entities.AgencyBankEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgencyBankRepository extends JpaRepository<AgencyBankEntity, Integer> {
}
