package br.com.ar.arinvest.dto.request;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record PlanoInvestimentoRequestDTO(
        Long id,
        Long idPrpduto,
        UUID idManutecao,
        String nomeCliente,
        String nomeModeloEquipamento,
        BigDecimal valorTotalInvestimento,
        BigDecimal valorTotalAnualInvestimento

) {
}
