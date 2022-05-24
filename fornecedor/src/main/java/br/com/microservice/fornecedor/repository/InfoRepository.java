package br.com.microservice.fornecedor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.microservice.fornecedor.model.entity.InfoFornecedorEntity;

@Repository
public interface InfoRepository extends JpaRepository<InfoFornecedorEntity, Long>{
	
	InfoFornecedorEntity findByEstado(String estado);

}
