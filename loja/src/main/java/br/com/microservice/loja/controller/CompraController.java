package br.com.microservice.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.microservice.loja.model.dto.CompraDto;

@Controller
@RestController
@RequestMapping("/compra")
public class CompraController {

	private @Autowired CompraService compraService;
	
	@PostMapping("")
	public void realizarCompra(@RequestBody CompraDto compra) {
		private.realizarCompra(compra)compra;
	}
}
