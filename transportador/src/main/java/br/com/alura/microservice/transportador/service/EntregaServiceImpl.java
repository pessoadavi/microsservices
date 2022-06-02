package br.com.alura.microservice.transportador.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.microservice.transportador.dto.EntregaDto;
import br.com.alura.microservice.transportador.dto.VoucherDto;
import br.com.alura.microservice.transportador.model.EntregaEntity;
import br.com.alura.microservice.transportador.repository.EntregaRepository;

@Service
public class EntregaServiceImpl implements EntregaService {
	
	@Autowired
	private EntregaRepository repository;

	public VoucherDto reservaEntrega(EntregaDto pedidoDTO) {
		
		EntregaEntity entrega = new EntregaEntity();
		entrega.setDataParaBusca(pedidoDTO.getDataParaEntrega());
		entrega.setPrevisaoParaEntrega(pedidoDTO.getDataParaEntrega().plusDays(1l));
		entrega.setEnderecoDestino(pedidoDTO.getEnderecoDestino());
		entrega.setEnderecoOrigem(pedidoDTO.getEnderecoOrigem());
		entrega.setPedidoId(pedidoDTO.getPedidoId());
		
		repository.save(entrega);
		
		VoucherDto voucher = new VoucherDto();
		voucher.setNumero(entrega.getId());
		voucher.setPrevisaoParaEntrega(entrega.getPrevisaoParaEntrega());
		return voucher;
	}

}
