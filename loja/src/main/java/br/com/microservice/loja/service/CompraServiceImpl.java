package br.com.microservice.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.microservice.loja.model.dto.CompraDto;
import br.com.microservice.loja.model.dto.InfoFornecedorDto;
import br.com.microservice.loja.model.dto.InfoPedidoDto;
import br.com.microservice.loja.model.entity.CompraEntity;
import br.com.microservice.loja.service.feignClients.FornecedorFeignClient;

@Service
public class CompraServiceImpl implements CompraService {

	private @Autowired FornecedorFeignClient fornecedorFeignClient;
	
	@Override
	public CompraEntity realizaCompra(CompraDto compra) {
				
		InfoFornecedorDto info = fornecedorFeignClient.getInfoPorEstado(compra.getEndereco().getEstado());
		
		InfoPedidoDto pedido = fornecedorFeignClient.realizaPedido(compra.getItens());
		
		System.out.println(info.getEndereco());
	
		CompraEntity compraSalva = new CompraEntity();
		compraSalva.setPedidoId(pedido.getId());
		compraSalva.setTempoDePreparo(pedido.getTempoDePreparo());
		compraSalva.setEnderecoDestino(compra.getEndereco().toString());
		
		return compraSalva;
	}

}
