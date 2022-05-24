package br.com.microservice.fornecedor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.microservice.fornecedor.model.entity.InfoFornecedorEntity;
import br.com.microservice.fornecedor.repository.InfoRepository;

@Service
public class InfoServiceImpl implements InfoService {

	private @Autowired InfoRepository infoRepository;
	
	@Override
	public InfoFornecedorEntity getInfoPorEstado(String estado) {
		return infoRepository.findByEstado(estado);
	}

}
