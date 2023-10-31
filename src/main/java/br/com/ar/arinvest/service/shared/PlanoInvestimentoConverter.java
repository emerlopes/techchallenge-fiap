package br.com.ar.arinvest.service.shared;

import br.com.ar.arinvest.dto.StatusPlanoInvestimentoEnum;
import br.com.ar.arinvest.dto.request.PlanoInvestimentoRequestDTO;
import br.com.ar.arinvest.dto.response.PlanoInvestimentoResponseDTO;
import br.com.ar.arinvest.entities.PlanoInvestimentoEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class PlanoInvestimentoConverter {

    public PlanoInvestimentoEntity paraPlanoInvestimentoEntity(PlanoInvestimentoRequestDTO planoInvestimentoRequestDTO) {
        return new PlanoInvestimentoEntity().setId(planoInvestimentoRequestDTO.id())
                .setIdPrpduto(planoInvestimentoRequestDTO.idPrpduto())
                .setIdManutecao(planoInvestimentoRequestDTO.idManutecao())
                .setNomeCliente(planoInvestimentoRequestDTO.nomeCliente())
                .setNomeModeloEquipamento(planoInvestimentoRequestDTO.nomeModeloEquipamento())
                .setValorTotalInvestimento(planoInvestimentoRequestDTO.valorTotalInvestimento())
                .setValorTotalAnualInvestimento(planoInvestimentoRequestDTO.valorTotalAnualInvestimento())
                .setDataCriacaoPlanoInvestimento(LocalDate.now().minusDays(10))
                .setStatusPlanoInvestimento(StatusPlanoInvestimentoEnum.CRIADO);
    }

    public PlanoInvestimentoResponseDTO paraPlanoInvestimentoResponseDTO(PlanoInvestimentoEntity planoInvestimentoEntity) {
        return new PlanoInvestimentoResponseDTO().setId(planoInvestimentoEntity.getId())
                .setIdManutecao(planoInvestimentoEntity.getIdManutecao())
                .setNomeCliente(planoInvestimentoEntity.getNomeCliente())
                .setNomeModeloEquipamento(planoInvestimentoEntity.getNomeModeloEquipamento())
                .setValorTotalInvestimento(planoInvestimentoEntity.getValorTotalInvestimento())
                .setValorTotalAnualInvestimento(planoInvestimentoEntity.getValorTotalAnualInvestimento())
                .setDataCriacaoPlanoInvestimento(planoInvestimentoEntity.getDataCriacaoPlanoInvestimento())
                .setDataAtualizacaoPlanoInvestimento(planoInvestimentoEntity.getDataAtualizacaoPlanoInvestimento())
                .setStatusPlanoInvestimento(planoInvestimentoEntity.getStatusPlanoInvestimento());
    }

    public List<PlanoInvestimentoResponseDTO> paraPlanoInvestimentoResponseDTO(
            List<PlanoInvestimentoEntity> planoInvestimentoEntity) {

        var responseDTOList = new ArrayList<PlanoInvestimentoResponseDTO>();
        for (PlanoInvestimentoEntity entity : planoInvestimentoEntity) {
            var responseDTO = new PlanoInvestimentoResponseDTO();

            responseDTO.setId(entity.getId());
            responseDTO.setIdManutecao(entity.getIdManutecao());
            responseDTO.setNomeCliente(entity.getNomeCliente());
            responseDTO.setNomeModeloEquipamento(entity.getNomeModeloEquipamento());
            responseDTO.setValorTotalInvestimento(entity.getValorTotalInvestimento());
            responseDTO.setValorTotalAnualInvestimento(entity.getValorTotalAnualInvestimento());
            responseDTO.setDataCriacaoPlanoInvestimento(entity.getDataCriacaoPlanoInvestimento());
            responseDTO.setDataAtualizacaoPlanoInvestimento(entity.getDataAtualizacaoPlanoInvestimento());
            responseDTO.setStatusPlanoInvestimento(entity.getStatusPlanoInvestimento());

            responseDTOList.add(responseDTO);

        }

        return responseDTOList;

    }

}
