package br.com.ar.arinvest.dto.response;

import br.com.ar.arinvest.dto.StatusPlanoInvestimentoEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class PlanoInvestimentoResponseDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("id_produto")
    private Long idProduto = 1L;

    @JsonProperty("id_manutencao")
    private UUID idManutecao = UUID.randomUUID();

    @JsonProperty("nome_cliente")
    private String nomeCliente;

    @JsonProperty("nome_modelo_equipamento")
    private String nomeModeloEquipamento;

    @JsonProperty("valor_total_investimento")
    private BigDecimal valorTotalInvestimento;

    @JsonProperty("valor_total_anual_investimento")
    private BigDecimal valorTotalAnualInvestimento;

    @JsonProperty("data_criacao_plano_investimento")
    private LocalDate dataCriacaoPlanoInvestimento;

    @JsonProperty("data_atualizacao_plano_investimento")
    private LocalDate dataAtualizacaoPlanoInvestimento;

    @JsonProperty("status_plano_investimento")
    private StatusPlanoInvestimentoEnum statusPlanoInvestimento;
}
