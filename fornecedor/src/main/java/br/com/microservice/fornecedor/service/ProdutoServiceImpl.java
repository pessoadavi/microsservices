package br.com.microservice.fornecedor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.microservice.fornecedor.model.entity.ProdutoEntity;
import br.com.microservice.fornecedor.repository.ProdutoRepository;

@Service
public class ProdutoServiceImpl implements ProdutoService{

	private @Autowired ProdutoRepository repository;
	
	@Override
	public List<ProdutoEntity> getProdutosPorEstado(String estado) {
		return repository.findByEstado(estado);
	}

}
