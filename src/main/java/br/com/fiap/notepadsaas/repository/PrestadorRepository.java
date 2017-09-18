package br.com.fiap.notepadsaas.repository;

import br.com.fiap.notepadsaas.model.Prestador;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PrestadorRepository extends MongoRepository<Prestador, String> {

    List<Prestador> findByNome(String nome);

    Prestador findById(String id);

    Prestador findByCpf(String cpf);

}
