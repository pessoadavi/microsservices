package br.com.microservice.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.microservice.loja.model.dto.CompraDto;
import br.com.microservice.loja.model.dto.InfoFornecedorDto;
import br.com.microservice.loja.service.feignClients.FornecedorFeignClient;

@Service
public class CompraServiceImpl implements CompraService {

	private @Autowired FornecedorFeignClient fornecedorFeignClient;
	
	@Override
	public void realizaCompra(CompraDto compra) {
				
		InfoFornecedorDto info = fornecedorFeignClient.getInfoPorEstado(compra.getEndereco().getEstado());
		
		System.out.println(info.getEndereco());
	}

}
