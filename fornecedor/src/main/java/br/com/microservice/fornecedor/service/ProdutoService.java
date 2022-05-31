package br.com.microservice.fornecedor.service;

import java.util.List;

import br.com.microservice.fornecedor.model.entity.ProdutoEntity;

public interface ProdutoService {
	
	List<ProdutoEntity> getProdutosPorEstado(String estado);
}
