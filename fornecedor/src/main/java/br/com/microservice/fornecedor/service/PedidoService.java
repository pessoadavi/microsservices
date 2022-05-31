package br.com.microservice.fornecedor.service;

import java.util.List;

import br.com.microservice.fornecedor.model.dto.ItemDoPedidoDto;
import br.com.microservice.fornecedor.model.entity.PedidoEntity;
import br.com.microservice.fornecedor.model.entity.PedidoItemEntity;

public interface PedidoService {
	
	PedidoEntity realizaPedido(List<ItemDoPedidoDto> itens);
	
	PedidoEntity getPedidoPorId(Long id);
	
	List<PedidoItemEntity> toPedidoItem(List<ItemDoPedidoDto> itens);
}
