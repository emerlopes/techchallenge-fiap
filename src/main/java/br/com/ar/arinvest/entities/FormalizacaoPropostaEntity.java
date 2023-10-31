package br.com.ar.arinvest.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_formalizacao_proposta")
@Accessors(chain = true)
public class FormalizacaoPropostaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private PlanoInvestimentoEntity planoInvestimento;

    private LocalDateTime dataCriacaoFormalizacaoProposta = LocalDateTime.now();

}
