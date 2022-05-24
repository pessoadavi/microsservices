package br.com.microservice.loja.service;

import br.com.microservice.loja.model.dto.CompraDto;

public interface CompraService {

	void realizaCompra(CompraDto compra);
}
