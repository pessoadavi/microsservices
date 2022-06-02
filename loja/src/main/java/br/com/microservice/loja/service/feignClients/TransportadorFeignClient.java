package br.com.microservice.loja.service.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.microservice.loja.model.dto.InfoEntregaDto;
import br.com.microservice.loja.model.dto.InfoVoucherDto;

@FeignClient(name = "transportador")
public interface TransportadorFeignClient {
	
	@PostMapping("/entrega")
	public InfoVoucherDto reservaEntrega(@RequestBody InfoEntregaDto pedidoDto);

}
