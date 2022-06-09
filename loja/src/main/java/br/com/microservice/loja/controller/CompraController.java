package br.com.microservice.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.microservice.loja.model.dto.CompraDto;
import br.com.microservice.loja.model.entity.CompraEntity;
import br.com.microservice.loja.service.CompraService;
import br.com.microservice.loja.service.CompraService;

@Controller
@RestController
@RequestMapping("/compra")
public class CompraController {

	private @Autowired CompraService compraService;
	
	@PostMapping("")
	public CompraEntity realizarCompra(@RequestBody CompraDto compra) {
		
		return compraService.realizaCompra(compra);
	}
	
	@GetMapping("/{id}")
	public CompraEntity getCompraById(@PathVariable Long id) {
		return compraService.getCompraById(id);
	}
}
