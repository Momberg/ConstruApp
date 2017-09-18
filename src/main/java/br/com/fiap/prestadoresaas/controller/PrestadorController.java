package br.com.fiap.prestadoresaas.controller;

import br.com.fiap.prestadoresaas.model.Prestador;
import br.com.fiap.prestadoresaas.repository.PrestadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/prestador")
public class PrestadorController {

    @Autowired
    private PrestadorRepository prestadorRepository;

    @GetMapping
    private List<Prestador> findAll() {
        return prestadorRepository.findAll();
    }

    @GetMapping(value = "/nome={nome}")
    private List<Prestador> findByTitulo(@PathVariable(value = "nome") String q) {
        return prestadorRepository.findByNome(q);
    }

    @GetMapping(value = "/id={id}")
    private Prestador findById(@PathVariable(value = "id") String q) {
        return prestadorRepository.findById(q);
    }

    @GetMapping(value = "/cpf={cpf}")
    private Prestador findByCpf(@PathVariable(value = "cpf") String q) {
        return prestadorRepository.findByCpf(q);
    }

    @PostMapping
    private void save(@RequestBody Prestador prestador) {
        prestadorRepository.save(prestador);
    }
}
