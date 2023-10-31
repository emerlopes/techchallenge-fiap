package br.com.ar.arinvest.service;


import br.com.ar.arinvest.controller.exceptions.ControllerNotFoundException;
import br.com.ar.arinvest.dto.StatusPlanoInvestimentoEnum;
import br.com.ar.arinvest.dto.response.FormalizacaoPropostaResponseDTO;
import br.com.ar.arinvest.repository.IFormalizacaoPropostaRepository;
import br.com.ar.arinvest.repository.IPlanoInvestimentoRepository;
import br.com.ar.arinvest.service.shared.FormalizacaoPropostaConverter;
import org.springframework.stereotype.Service;

@Service
public class FormalizacaoPropostaService {

    private final IFormalizacaoPropostaRepository formalizacaoPropostaRepository;


    private final IPlanoInvestimentoRepository planoInvestimentoRepository;

    private final FormalizacaoPropostaConverter formalizacaoPropostaConverter;

    public FormalizacaoPropostaService(IFormalizacaoPropostaRepository formalizacaoPropostaRepository, IPlanoInvestimentoRepository planoInvestimentoRepository, FormalizacaoPropostaConverter formalizacaoPropostaConverter) {
        this.formalizacaoPropostaRepository = formalizacaoPropostaRepository;
        this.planoInvestimentoRepository = planoInvestimentoRepository;
        this.formalizacaoPropostaConverter = formalizacaoPropostaConverter;
    }

    public FormalizacaoPropostaResponseDTO cadastrarFormalizacaoProposta(Long id) {

        final var planoInvestimento = planoInvestimentoRepository.findById(id).orElseThrow(
                () -> new ControllerNotFoundException("Plano de investimento não encontrado"));

        planoInvestimento.setStatusPlanoInvestimento(StatusPlanoInvestimentoEnum.EM_FORMALIZACAO);

        var formalizacaoPropostaEntity = formalizacaoPropostaConverter.paraFormalizacaoPropostaEntity(
                planoInvestimento);

        formalizacaoPropostaEntity = formalizacaoPropostaRepository.save(formalizacaoPropostaEntity);

        return formalizacaoPropostaConverter.paraFormalizacaoPropostaResponseDTO(formalizacaoPropostaRepository.save(formalizacaoPropostaEntity));
    }

}
