package br.com.microservice.fornecedor.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.microservice.fornecedor.model.dto.ItemDoPedidoDto;
import br.com.microservice.fornecedor.model.entity.InfoFornecedorEntity;
import br.com.microservice.fornecedor.model.entity.PedidoEntity;
import br.com.microservice.fornecedor.model.entity.PedidoItemEntity;
import br.com.microservice.fornecedor.model.entity.ProdutoEntity;
import br.com.microservice.fornecedor.repository.PedidoRepository;
import br.com.microservice.fornecedor.repository.ProdutoRepository;

@Service
public class PedidoServiceImpl implements PedidoService{

	private @Autowired PedidoRepository pedidoRepository;
	private @Autowired ProdutoRepository produtoRepository;
	
	@Override
	public PedidoEntity realizaPedido(List<ItemDoPedidoDto> itens) {
		
		if(itens == null) {
			return null;
		}
		
		List<PedidoItemEntity> pedidoItens = toPedidoItem(itens);
		PedidoEntity pedido = new PedidoEntity(pedidoItens);
		pedido.setTempoDePreparo(itens.size());
		return pedidoRepository.save(pedido);
	}

	@Override
	public PedidoEntity getPedidoPorId(Long id) {
		return this.pedidoRepository.findById(id).orElse(new PedidoEntity());
	}

	@Override
	public List<PedidoItemEntity> toPedidoItem(List<ItemDoPedidoDto> itens) {
		List<Long> idsProdutos = itens
				.stream()
				.map(item -> item.getId())
				.collect(Collectors.toList());
		
		List<ProdutoEntity> produtosDoPedido = produtoRepository.findByIdIn(idsProdutos);
		
		List<PedidoItemEntity> pedidoItens = itens
			.stream()
			.map(item -> {
				ProdutoEntity produto = produtosDoPedido
						.stream()
						.filter(p -> p.getId() == item.getId())
						.findFirst().get();
				
				PedidoItemEntity pedidoItem = new PedidoItemEntity();
				pedidoItem.setProduto(produto);
				pedidoItem.setQuantidade(item.getQuantidade());
				return pedidoItem;
			})
			.collect(Collectors.toList());
		return pedidoItens;
	}

}
