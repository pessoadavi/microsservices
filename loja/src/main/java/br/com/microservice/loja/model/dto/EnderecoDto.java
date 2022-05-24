package br.com.microservice.loja.model.dto;

import lombok.Data;

@Data
public class EnderecoDto {

	private String rua;
	private Integer numero;
	private String estado; 
}
