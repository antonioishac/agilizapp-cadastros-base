package br.com.agillizapp.cadastros.domain.repositories;

import br.com.agillizapp.cadastros.domain.repositories.entities.AgencyBankEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AgencyBankRepository extends JpaRepository<AgencyBankEntity, Integer> {

    @Query("SELECT a FROM AgencyBankEntity a WHERE a.code = :code")
    Optional<AgencyBankEntity> findAgencyBankByCode(@Param("code") int code);

}
