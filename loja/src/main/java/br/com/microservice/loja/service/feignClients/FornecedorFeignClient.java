package br.com.microservice.loja.service.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.microservice.loja.model.dto.InfoFornecedorDto;

@FeignClient(name = "fornecedor", path= "/info")
public interface FornecedorFeignClient {

	@GetMapping("/{estado}")
	InfoFornecedorDto getInfoPorEstado(@PathVariable String estado);
}
