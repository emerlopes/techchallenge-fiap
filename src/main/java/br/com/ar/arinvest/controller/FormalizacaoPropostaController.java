package br.com.ar.arinvest.controller;

import br.com.ar.arinvest.service.FormalizacaoPropostaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/formalizacao-proposta")
public class FormalizacaoPropostaController {

    private final FormalizacaoPropostaService formalizacaoPropostaService;

    public FormalizacaoPropostaController(FormalizacaoPropostaService formalizacaoPropostaService) {
        this.formalizacaoPropostaService = formalizacaoPropostaService;
    }

    @PostMapping
    @RequestMapping("/{id}")
    public ResponseEntity<?> cadastrarFormalizacaoProposta(@PathVariable Long id) {
        final var formalizacaoPropostaResponseDTO = formalizacaoPropostaService.cadastrarFormalizacaoProposta(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(formalizacaoPropostaResponseDTO);
    }
}
