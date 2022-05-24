package br.com.microservice.fornecedor.service;

import br.com.microservice.fornecedor.model.entity.InfoFornecedorEntity;

public interface InfoService {

	InfoFornecedorEntity getInfoPorEstado(String estado);
	
}
