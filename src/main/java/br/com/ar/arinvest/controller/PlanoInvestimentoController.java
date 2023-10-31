package br.com.ar.arinvest.controller;

import br.com.ar.arinvest.dto.request.PlanoInvestimentoAtualizacaoRequestDTO;
import br.com.ar.arinvest.dto.request.PlanoInvestimentoRequestDTO;
import br.com.ar.arinvest.service.PlanoInvestimentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/planos-investimento")
public class PlanoInvestimentoController {

    private final PlanoInvestimentoService planoInvestimentoService;

    public PlanoInvestimentoController(PlanoInvestimentoService planoInvestimentoService) {
        this.planoInvestimentoService = planoInvestimentoService;
    }

    @GetMapping
    public ResponseEntity<?> consultarPlanosInvestimento() {
        return ResponseEntity.ok(planoInvestimentoService.consultarPlanosInvestimento());
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<?> consultarPlanosInvestimentoPorID(@PathVariable Long id) {
        return ResponseEntity.ok(planoInvestimentoService.consultarPlanosInvestimentoPorID(id));
    }

    @PostMapping
    public ResponseEntity<?> cadastrarPlanoInvestimento(@RequestBody PlanoInvestimentoRequestDTO requestDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(planoInvestimentoService.cadastrarPlanoInvestimento(requestDTO));
    }

    @PutMapping
    @RequestMapping("/{id}/atualizar-planos")
    public ResponseEntity<?> atualizarPlanoInvestimento(
            @PathVariable Long id, @RequestBody PlanoInvestimentoAtualizacaoRequestDTO requestDTO) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(planoInvestimentoService.atualizarPLanoInvestimento(id, requestDTO));
    }

    @DeleteMapping
    @RequestMapping("/{id}/deletar-planos")
    public ResponseEntity<?> deletarPlanoInvestimento(@PathVariable Long id) {
        planoInvestimentoService.deletarPlanoInvestimento(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
