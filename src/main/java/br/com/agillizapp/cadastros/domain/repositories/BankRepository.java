package br.com.agillizapp.cadastros.domain.repositories;

import br.com.agillizapp.cadastros.domain.repositories.custom.BankCustomRepository;
import br.com.agillizapp.cadastros.domain.repositories.entities.BankEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankRepository extends CrudRepository<BankEntity, Integer>, BankCustomRepository {

    @Query("SELECT b FROM BankEntity b WHERE b.code = :code")
    Optional<BankEntity> findBankByCode(@Param("code") String code);
}
