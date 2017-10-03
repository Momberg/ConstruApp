package br.com.fiap.prestadoresaas.controller;

import br.com.fiap.prestadoresaas.model.Servico;
import br.com.fiap.prestadoresaas.repository.PrestadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import br.com.fiap.prestadoresaas.repository.ServicoRepository;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/servico")
public class ServicoController {

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private PrestadorRepository prestadorRepository;

    @GetMapping
    private List<Servico> findAll() {
        return servicoRepository.findAll();
    }

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
        if(verifyIfIdPrestadorExists(servico)) return;
        servicoRepository.save(servico);
    }

    private Boolean verifyIfIdPrestadorExists(Servico servico) {
        String id = ObjectUtils.isEmpty(prestadorRepository.findById(servico.getIdPrestador())) ? "" : servico.getIdPrestador();
        if(id.isEmpty()) return Boolean.TRUE;
        return Boolean.FALSE;
    }

}
