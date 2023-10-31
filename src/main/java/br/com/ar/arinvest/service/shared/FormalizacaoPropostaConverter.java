package br.com.ar.arinvest.service.shared;

import br.com.ar.arinvest.dto.response.FormalizacaoPropostaResponseDTO;
import br.com.ar.arinvest.entities.FormalizacaoPropostaEntity;
import br.com.ar.arinvest.entities.PlanoInvestimentoEntity;
import org.springframework.stereotype.Component;

@Component
public class FormalizacaoPropostaConverter {

    public FormalizacaoPropostaEntity paraFormalizacaoPropostaEntity(PlanoInvestimentoEntity planoInvestimento) {
        return new FormalizacaoPropostaEntity().setPlanoInvestimento(planoInvestimento);
    }

    public FormalizacaoPropostaResponseDTO paraFormalizacaoPropostaResponseDTO(FormalizacaoPropostaEntity formalizacaoPropostaEntity) {
        return new FormalizacaoPropostaResponseDTO().setId(formalizacaoPropostaEntity.getId())
                .setDataCriacaoFormalizacaoProposta(formalizacaoPropostaEntity.getDataCriacaoFormalizacaoProposta())
                .setPlanoInvestimento(formalizacaoPropostaEntity.getPlanoInvestimento());
    }
}
