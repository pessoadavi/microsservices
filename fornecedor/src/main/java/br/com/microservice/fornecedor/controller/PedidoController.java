package br.com.microservice.fornecedor.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.microservice.fornecedor.model.dto.ItemDoPedidoDto;
import br.com.microservice.fornecedor.model.entity.PedidoEntity;
import br.com.microservice.fornecedor.service.PedidoService;

@Controller
@RestController
@RequestMapping("/pedido")
public class PedidoController {

	private @Autowired PedidoService pedidoService;
	
	private static final Logger LOG = LoggerFactory.getLogger(PedidoController.class);
	
	@PostMapping("")
	public PedidoEntity realizaPedido(@RequestBody List<ItemDoPedidoDto> produtos) {
		
		LOG.info("Pedido recebido");
		return pedidoService.realizaPedido(produtos); 
	}
	
	@GetMapping("{id}")
	public PedidoEntity getPedidoPorId(@PathVariable Long id) {
		return pedidoService.getPedidoPorId(id);
	}
}
