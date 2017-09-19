package br.com.fiap.notepadsaas.controller;

import br.com.fiap.notepadsaas.model.Servico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.com.fiap.notepadsaas.repository.ServicoRepository;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/servico")
public class ServicoController {

    @Autowired
    ServicoRepository servicoRepository;

    @GetMapping(value = "/lista/tipoServico={tipoServico}")
    private List<Servico> findListByTipoServico(@PathVariable(value = "tipoServico") String q){
        return servicoRepository.findListByTipoServico(q);
    }

    @GetMapping(value = "/lista/localServico={localServico}")
    private List<Servico> findListByLocalServico(@PathVariable(value = "localServico") String q){
        return servicoRepository.findListByLocalServico(q);
    }

    @GetMapping(value = "/lista/idPrestador={idPrestador}")
    private List<Servico> findListByIdPrestador(@PathVariable(value = "idPrestador") String q){
        return servicoRepository.findListByIdPrestador(q);
    }

    @PostMapping
    private void save(@RequestBody Servico servico) {
        servicoRepository.save(servico);
    }

}
