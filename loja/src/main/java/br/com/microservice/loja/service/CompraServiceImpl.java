package br.com.microservice.loja.service;

import java.time.LocalDate;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.microservice.loja.enums.CompraStateEnum;
import br.com.microservice.loja.model.dto.CompraDto;
import br.com.microservice.loja.model.dto.InfoEntregaDto;
import br.com.microservice.loja.model.dto.InfoFornecedorDto;
import br.com.microservice.loja.model.dto.InfoPedidoDto;
import br.com.microservice.loja.model.dto.InfoVoucherDto;
import br.com.microservice.loja.model.entity.CompraEntity;
import br.com.microservice.loja.repository.CompraRepository;
import br.com.microservice.loja.service.feignClients.FornecedorFeignClient;
import br.com.microservice.loja.service.feignClients.TransportadorFeignClient;

@Service
public class CompraServiceImpl implements CompraService {

	private @Autowired CompraRepository compraRepository;
	private @Autowired FornecedorFeignClient fornecedorFeignClient;
	private @Autowired TransportadorFeignClient transportadorFeignClient; 
	
	private static final Logger LOG = LoggerFactory.getLogger(CompraServiceImpl.class);
	
	@Override
	@HystrixCommand(threadPoolKey = "getCompraByIdThreadPool")
	public CompraEntity getCompraById(Long id) {
		return compraRepository.findById(id).orElse(new CompraEntity());
	}
	
	
	
	@Override
	@HystrixCommand(fallbackMethod = "realizaCompraFallBack", threadPoolKey = "realizaCompraThreadPool")
	public CompraEntity realizaCompra(CompraDto compra) {
	
		CompraEntity compraSalva = new CompraEntity();
		compraSalva.setState(CompraStateEnum.RECEBIDO);
		compraSalva.setEnderecoDestino(compra.getEndereco().toString());
		compraRepository.saveAndFlush(compraSalva);
		compra.setCompraId(compraSalva.getId());
		
		InfoFornecedorDto info = fornecedorFeignClient.getInfoPorEstado(compra.getEndereco().getEstado());				
		InfoPedidoDto pedido = fornecedorFeignClient.realizaPedido(compra.getItens());
		compraSalva.setState(CompraStateEnum.PEDIDO_REALIZADO);
		
		compraSalva.setPedidoId(pedido.getId());
		compraSalva.setTempoDePreparo(pedido.getTempoDePreparo());
		compraRepository.saveAndFlush(compraSalva);
		
		if(1==1) throw new RuntimeException();
		
		InfoEntregaDto entregaDto = new InfoEntregaDto();
		entregaDto.setPedidoId(pedido.getId());
		LocalDate time = LocalDate.now().plusDays(pedido.getTempoDePreparo());
		entregaDto.setDataParaEntrega(time);
		entregaDto.setEnderecoOrigem(info.getEndereco());
		
		InfoVoucherDto voucher = transportadorFeignClient.reservaEntrega(entregaDto);		
	
		compraSalva.setState(CompraStateEnum.RESERVA_ENTREGA_REALIZADA);
		compraSalva.setDataParaEntrega(voucher.getPrevisaoParaEntrega());
		compraSalva.setVoucher(voucher.getNumero());
		compraRepository.saveAndFlush(compraSalva);
			
		return compraSalva;
	}

	@Override
	public CompraEntity realizaCompraFallBack(CompraDto compra) {
		
		if(compra.getCompraId() != null) {
			return compraRepository.findById(compra.getCompraId()).get();
		}
		
		CompraEntity compraFallBack= new CompraEntity();
		compraFallBack.setEnderecoDestino(compra.getEndereco().toString());
		return compraFallBack;
	}

}
