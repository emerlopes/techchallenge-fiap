package br.com.ar.arinvest.repository;

import br.com.ar.arinvest.entities.FormalizacaoPropostaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFormalizacaoPropostaRepository extends JpaRepository<FormalizacaoPropostaEntity, Long> {
}
