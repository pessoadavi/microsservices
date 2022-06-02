package br.com.microservice.loja.model.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class InfoEntregaDto {

	private Long pedidoId;

	private LocalDate dataParaEntrega;
	
	private String enderecoOrigem;
	
	private String enderecoDestino;
}
