package br.com.microservice.loja.service.feignClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.microservice.loja.model.dto.InfoFornecedorDto;
import br.com.microservice.loja.model.dto.InfoPedidoDto;
import br.com.microservice.loja.model.dto.ItemDaCompraDto;

@FeignClient(name = "fornecedor")
public interface FornecedorFeignClient {

	@GetMapping("/info/{estado}")
	InfoFornecedorDto getInfoPorEstado(@PathVariable String estado);
	
	@PostMapping("/pedido")
	InfoPedidoDto realizaPedido(List<ItemDaCompraDto> itens);
}
