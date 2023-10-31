package br.com.ar.arinvest.entities;


import br.com.ar.arinvest.dto.StatusPlanoInvestimentoEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@Table(name = "tb_plano_investimento")
@Accessors(chain = true)
public class PlanoInvestimentoEntity {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter
    private Long idPrpduto = 1L;

    private UUID idManutecao = UUID.randomUUID();

    private String nomeCliente;

    private String nomeModeloEquipamento;

    private BigDecimal valorTotalInvestimento;

    private BigDecimal valorTotalAnualInvestimento;

    private LocalDate dataCriacaoPlanoInvestimento;

    private LocalDate dataAtualizacaoPlanoInvestimento;

    private StatusPlanoInvestimentoEnum statusPlanoInvestimento;

}
