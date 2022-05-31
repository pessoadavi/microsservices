package br.com.microservice.loja.model.entity;

import lombok.Data;

@Data
public class CompraEntity {

	private Long pedidoId;
	
	private Integer tempoDePreparo;
	
	private String enderecoDestino;
}
