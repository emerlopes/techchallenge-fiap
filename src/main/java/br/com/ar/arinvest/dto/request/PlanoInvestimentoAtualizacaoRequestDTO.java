package br.com.ar.arinvest.dto.request;

import java.math.BigDecimal;
import java.util.UUID;

public record PlanoInvestimentoAtualizacaoRequestDTO(
        Long id,
        Long idPrpduto,
        UUID idManutecao,
        String nomeCliente,
        String nomeModeloEquipamento,
        BigDecimal valorTotalInvestimento,
        BigDecimal valorTotalAnualInvestimento,
        String statusPlanoInvestimentoEnum

) {
}
