package br.com.fiap.prestadoresaas.repository;

import br.com.fiap.prestadoresaas.model.Prestador;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PrestadorRepository extends MongoRepository<Prestador, String> {

    Prestador findByNome(String nome);

    Prestador findById(String id);

    Prestador findByCpf(String cpf);

    List<Prestador> findListByNome(String nome);

    List<Prestador> findListByCpf(String cpf);

}
