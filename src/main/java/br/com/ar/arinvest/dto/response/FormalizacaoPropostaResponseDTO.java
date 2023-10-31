package br.com.ar.arinvest.dto.response;

import br.com.ar.arinvest.entities.PlanoInvestimentoEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class FormalizacaoPropostaResponseDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("id_plano_investimento")
    private PlanoInvestimentoEntity planoInvestimento;

    @JsonProperty("data_criacao_formalizacao_proposta")
    private LocalDateTime dataCriacaoFormalizacaoProposta;

}
