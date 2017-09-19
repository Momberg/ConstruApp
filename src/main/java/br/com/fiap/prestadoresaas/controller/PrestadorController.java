package br.com.fiap.prestadoresaas.controller;

import br.com.fiap.prestadoresaas.model.Prestador;
import br.com.fiap.prestadoresaas.repository.PrestadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.ObjectUtils.isEmpty;

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
    private Prestador findByNome(@PathVariable(value = "nome") String q) {
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

    @GetMapping(value = "/lista/nome={nome}")
    private List<Prestador> findListByNome(@PathVariable(value = "nome") String q){
        return prestadorRepository.findListByNome(q);
    }

    @GetMapping(value = "/lista/cpf={cpf}")
    private List<Prestador> findListByCpf(@PathVariable(value = "cpf") String q){
        return prestadorRepository.findListByCpf(q);
    }

    @PostMapping
    private void save(@RequestBody Prestador prestador) {
        if(verifyIfPrestadorExists(prestador)){
            return;
        }
        prestadorRepository.save(prestador);
    }

    private Boolean verifyIfPrestadorExists(Prestador prestador){
        Prestador p = prestadorRepository.findByCpf(prestador.getcpf());
        String cpf = ObjectUtils.isEmpty(p) ? "" : p.getcpf();
        if(!(prestador.getcpf().trim()).equals(cpf)){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

}
