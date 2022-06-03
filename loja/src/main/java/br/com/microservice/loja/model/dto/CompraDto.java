package br.com.microservice.loja.model.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class CompraDto {

	@JsonIgnore
	private Long CompraId;
	private List<ItemDaCompraDto> itens;
	private EnderecoDto endereco;
}
