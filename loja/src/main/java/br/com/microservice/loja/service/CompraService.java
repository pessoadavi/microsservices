package br.com.microservice.loja.service;

import br.com.microservice.loja.model.dto.CompraDto;
import br.com.microservice.loja.model.entity.CompraEntity;

public interface CompraService {

	CompraEntity realizaCompra(CompraDto compra);
}
