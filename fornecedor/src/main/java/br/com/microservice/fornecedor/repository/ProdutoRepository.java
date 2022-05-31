package br.com.microservice.fornecedor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.microservice.fornecedor.model.entity.ProdutoEntity;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long>{

	List<ProdutoEntity> findByEstado(String estado);
	
	List<ProdutoEntity> findByIdIn(List<Long> ids);
}
