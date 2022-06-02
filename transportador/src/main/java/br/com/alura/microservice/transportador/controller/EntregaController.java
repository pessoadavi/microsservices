package br.com.alura.microservice.transportador.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.microservice.transportador.dto.EntregaDto;
import br.com.alura.microservice.transportador.dto.VoucherDto;
import br.com.alura.microservice.transportador.service.EntregaService;

@RestController
@RequestMapping("/entrega")
public class EntregaController {
	
	@Autowired
	private EntregaService entregaService;

	@PostMapping("")
	public VoucherDto reservaEntrega(@RequestBody EntregaDto pedidoDTO) {
		return entregaService.reservaEntrega(pedidoDTO);
	}
}
