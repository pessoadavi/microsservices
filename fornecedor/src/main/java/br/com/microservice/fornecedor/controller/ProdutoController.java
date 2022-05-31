package br.com.microservice.fornecedor.controller;

import java.util.List;

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
import br.com.microservice.fornecedor.model.entity.ProdutoEntity;
import br.com.microservice.fornecedor.service.ProdutoService;

@Controller
@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
	private @Autowired ProdutoService produtoService;
	
	@GetMapping("/{estado}")
	public List<ProdutoEntity> getProdutosPorEstado(@PathVariable("estado") String estado) {
		return produtoService.getProdutosPorEstado(estado);
	}

}
