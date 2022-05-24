package br.com.microservice.loja.service;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.microservice.loja.model.dto.CompraDto;
import br.com.microservice.loja.model.dto.InfoFornecedorDto;

@Service
public class CompraServiceImpl implements CompraService {

	@Override
	public void realizaCompra(CompraDto compra) {
		
		RestTemplate client = new RestTemplate();
		ResponseEntity<InfoFornecedorDto> exchange = client.exchange("http://localhost:8081/info/"+compra.getEndereco().getEstado(), HttpMethod.GET, null, InfoFornecedorDto.class);
		System.out.println(exchange.getBody().getEndereco());
	}

}
