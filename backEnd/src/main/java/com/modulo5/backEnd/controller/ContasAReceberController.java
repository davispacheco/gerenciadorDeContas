package com.modulo5.backEnd.controller;

import com.modulo5.backEnd.DTO.ContasAReceberDTO;
import com.modulo5.backEnd.DTO.ContasAReceberRespostaDTO;
import com.modulo5.backEnd.enumeration.TipoRecebido;
import com.modulo5.backEnd.factory.AlugueisFactory;
import com.modulo5.backEnd.model.ContasAReceberModel;
import com.modulo5.backEnd.service.ContasAReceberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/contasreceber")
public class ContasAReceberController {
    @Autowired
    private ContasAReceberService contasAReceberService;

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping
    public ResponseEntity<List<ContasAReceberRespostaDTO>> buscarTodasContas() {
        return ResponseEntity.ok(contasAReceberService.buscarTodas());
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping(path = "/id/{id}")
    public ResponseEntity<ContasAReceberModel> buscarContaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(contasAReceberService.buscarPorId(id));
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping(path = "/status/{status}")
    public ResponseEntity<List<ContasAReceberModel>> buscarContaPorStatus(@PathVariable String status) {
        return ResponseEntity.ok(contasAReceberService.buscarPorStatus(status));
    }

    @CrossOrigin(origins = "http://127.0.0.1")
    @GetMapping(path = "/tiporecebido/{tipoRecebido}")
    public ResponseEntity<List<ContasAReceberModel>> buscarContaPorTipoRecebido(@PathVariable TipoRecebido tipoRecebido) {
        return ResponseEntity.ok(contasAReceberService.buscarPorTipoRecebido(tipoRecebido));
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping(path = "/datadevencimento/{dataDeVencimento}")
    public ResponseEntity<List<ContasAReceberModel>> buscarContaPorDataDeVencimento(@PathVariable String dataDeVencimento) {
        return ResponseEntity.ok(contasAReceberService.buscarPorDataDeVencimento(dataDeVencimento));
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping
    public ResponseEntity<ContasAReceberRespostaDTO> cadastrarConta(@Valid @RequestBody ContasAReceberDTO dto, AlugueisFactory alugueisFactory) {
        ContasAReceberModel conta = contasAReceberService.cadastrar(dto.converterParaObjeto(), alugueisFactory);
        return new ResponseEntity<>(ContasAReceberRespostaDTO.converterParaDTO(conta), HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PutMapping(path = "/id/{id}")
    public ResponseEntity<ContasAReceberRespostaDTO> alterarConta(@RequestBody ContasAReceberDTO dto, @PathVariable Long id) {
        ContasAReceberModel conta = contasAReceberService.alterar(dto.converterParaObjeto(), id);
        return ResponseEntity.ok(ContasAReceberRespostaDTO.converterParaDTO(conta));
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @DeleteMapping(path = "/id/{id}")
    public ResponseEntity<?> deletarConta(@PathVariable Long id) {
        contasAReceberService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
