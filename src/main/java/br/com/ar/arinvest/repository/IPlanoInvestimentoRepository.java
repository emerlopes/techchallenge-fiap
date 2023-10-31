package br.com.ar.arinvest.repository;

import br.com.ar.arinvest.entities.PlanoInvestimentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlanoInvestimentoRepository extends JpaRepository<PlanoInvestimentoEntity, Long> {
}
