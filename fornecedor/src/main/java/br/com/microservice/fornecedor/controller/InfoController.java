package br.com.microservice.fornecedor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.microservice.fornecedor.model.entity.InfoFornecedorEntity;
import br.com.microservice.fornecedor.service.InfoService;

@Controller
@RestController
@RequestMapping("/info")
public class InfoController {
	
	private @Autowired InfoService infoService;
	
	private static final Logger LOG = LoggerFactory.getLogger(InfoController.class);
			
	@GetMapping("/{estado}")
	public InfoFornecedorEntity getInfoPorEstado(@PathVariable String estado) {
		LOG.info("Recebido pedido de informações do fornecedor de {}.", estado);
		return infoService.getInfoPorEstado(estado);
	}

}
