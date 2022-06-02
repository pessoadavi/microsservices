package br.com.alura.microservice.transportador.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.microservice.transportador.model.EntregaEntity;

@Repository
public interface EntregaRepository extends CrudRepository<EntregaEntity, Long>{

}
