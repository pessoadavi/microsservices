package br.com.microservice.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.microservice.loja.model.dto.CompraDto;
import br.com.microservice.loja.model.dto.InfoFornecedorDto;

@Service
public class CompraServiceImpl implements CompraService {

	private @Autowired RestTemplate client;
	
	@Override
	public void realizaCompra(CompraDto compra) {
				
		ResponseEntity<InfoFornecedorDto> exchange = client.exchange("http://fornecedor:8081/info/"+compra.getEndereco().getEstado(), HttpMethod.GET, null, InfoFornecedorDto.class);
		System.out.println(exchange.getBody().getEndereco());
	}

}
