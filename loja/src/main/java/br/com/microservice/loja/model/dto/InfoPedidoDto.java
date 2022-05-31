package br.com.microservice.loja.model.dto;

import lombok.Data;

@Data
public class InfoPedidoDto {

	private Long id;
	
	private Integer tempoDePreparo;
}
