package br.com.ar.arinvest.service;

import br.com.ar.arinvest.controller.exceptions.ControllerNotFoundException;
import br.com.ar.arinvest.dto.request.PlanoInvestimentoAtualizacaoRequestDTO;
import br.com.ar.arinvest.dto.request.PlanoInvestimentoRequestDTO;
import br.com.ar.arinvest.dto.StatusPlanoInvestimentoEnum;
import br.com.ar.arinvest.dto.response.PlanoInvestimentoResponseDTO;
import br.com.ar.arinvest.entities.PlanoInvestimentoEntity;
import br.com.ar.arinvest.repository.IPlanoInvestimentoRepository;
import br.com.ar.arinvest.service.shared.PlanoInvestimentoConverter;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class PlanoInvestimentoService {

    private final IPlanoInvestimentoRepository planoInvestimentoRepository;

    private final PlanoInvestimentoConverter planoInvestimentoConverter;

    public PlanoInvestimentoService(IPlanoInvestimentoRepository planoInvestimentoRepository, PlanoInvestimentoConverter planoInvestimentoConverter) {
        this.planoInvestimentoRepository = planoInvestimentoRepository;
        this.planoInvestimentoConverter = planoInvestimentoConverter;
    }

    public List<PlanoInvestimentoResponseDTO> consultarPlanosInvestimento() {
        try {
            final var planosInvestimentoEntity = planoInvestimentoRepository.findAll();

            return planoInvestimentoConverter.paraPlanoInvestimentoResponseDTO(planosInvestimentoEntity);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao consultar planos de investimento", e);
        }
    }


    public PlanoInvestimentoResponseDTO consultarPlanosInvestimentoPorID(Long id) {
        final var planoInvestimentoEntity = planoInvestimentoRepository.findById(id).orElseThrow(
                () -> new ControllerNotFoundException("Plano de investimento não encontrado"));

        return planoInvestimentoConverter.paraPlanoInvestimentoResponseDTO(planoInvestimentoEntity);
    }

    public PlanoInvestimentoResponseDTO cadastrarPlanoInvestimento(PlanoInvestimentoRequestDTO planoInvestimentoRequestDTO) {

        var planoInvestimento = planoInvestimentoConverter.paraPlanoInvestimentoEntity(planoInvestimentoRequestDTO);
        planoInvestimento = planoInvestimentoRepository.save(planoInvestimento);

        return planoInvestimentoConverter.paraPlanoInvestimentoResponseDTO(planoInvestimento);
    }

    public PlanoInvestimentoResponseDTO atualizarPLanoInvestimento(Long id, PlanoInvestimentoAtualizacaoRequestDTO requestDTO) {
        var planoInvestimentoEntity = planoInvestimentoRepository.findById(id).orElseThrow(
                () -> new ControllerNotFoundException("Plano de investimento não encontrado"));

        planoInvestimentoEntity = planoInvestimentoRepository.save(planoInvestimentoEntity
                .setNomeCliente(requestDTO.nomeCliente())
                .setNomeModeloEquipamento(requestDTO.nomeModeloEquipamento())
                .setValorTotalInvestimento(
                        this.calcularValorTotalAnualInvestimento(requestDTO.valorTotalInvestimento()))
                .setValorTotalAnualInvestimento(requestDTO.valorTotalAnualInvestimento())
                .setDataAtualizacaoPlanoInvestimento(LocalDate.now())
                .setStatusPlanoInvestimento(StatusPlanoInvestimentoEnum.fromDescricao(requestDTO.statusPlanoInvestimentoEnum()))
        );

        return planoInvestimentoConverter.paraPlanoInvestimentoResponseDTO(planoInvestimentoEntity);
    }

    public void deletarPlanoInvestimento(Long id) {
        final var planoInvestimentoEntity = planoInvestimentoRepository.findById(id).orElseThrow(
                () -> new ControllerNotFoundException("Plano de investimento não encontrado"));

        planoInvestimentoRepository.delete(planoInvestimentoEntity);
    }

    private BigDecimal calcularValorTotalAnualInvestimento(BigDecimal valorTotalInvestimento) {
        return valorTotalInvestimento.multiply(BigDecimal.valueOf(0.5));
    }

}
