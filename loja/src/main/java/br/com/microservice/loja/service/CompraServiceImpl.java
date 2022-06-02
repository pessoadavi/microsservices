package br.com.microservice.loja.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.microservice.loja.model.dto.CompraDto;
import br.com.microservice.loja.model.dto.InfoFornecedorDto;
import br.com.microservice.loja.model.dto.InfoPedidoDto;
import br.com.microservice.loja.model.entity.CompraEntity;
import br.com.microservice.loja.repository.CompraRepository;
import br.com.microservice.loja.service.feignClients.FornecedorFeignClient;

@Service
public class CompraServiceImpl implements CompraService {

	private @Autowired CompraRepository compraRepository;
	private @Autowired FornecedorFeignClient fornecedorFeignClient;
	
	private static final Logger LOG = LoggerFactory.getLogger(CompraServiceImpl.class);
	
	@Override
	@HystrixCommand(threadPoolKey = "getCompraByIdThreadPool")
	public CompraEntity getCompraById(Long id) {
		return compraRepository.findById(id).orElse(new CompraEntity());
	}
	
	@Override
	@HystrixCommand(fallbackMethod = "realizaCompraFallBack", threadPoolKey = "realizaCompraThreadPool")
	public CompraEntity realizaCompra(CompraDto compra) {
				
		LOG.info("Buscando informações do fornecedor {}.", compra.getEndereco().getEstado());
		InfoFornecedorDto info = fornecedorFeignClient.getInfoPorEstado(compra.getEndereco().getEstado());		
		
		LOG.info("Realizando pedido.");
		InfoPedidoDto pedido = fornecedorFeignClient.realizaPedido(compra.getItens());
		
		System.out.println(info.getEndereco());
	
		CompraEntity compraSalva = new CompraEntity();
		compraSalva.setPedidoId(pedido.getId());
		compraSalva.setTempoDePreparo(pedido.getTempoDePreparo());
		compraSalva.setEnderecoDestino(compra.getEndereco().toString());
		
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		compraRepository.saveAndFlush(compraSalva);
		return compraSalva;
	}

	@Override
	public CompraEntity realizaCompraFallBack(CompraDto compra) {
		
		CompraEntity compraFallBack= new CompraEntity();
		compraFallBack.setEnderecoDestino(compra.getEndereco().toString());
		return compraFallBack;
	}

}
