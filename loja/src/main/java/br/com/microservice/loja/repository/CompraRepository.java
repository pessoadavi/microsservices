package br.com.microservice.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.microservice.loja.model.entity.CompraEntity;

@Repository
public interface CompraRepository extends JpaRepository<CompraEntity, Long>{

}
