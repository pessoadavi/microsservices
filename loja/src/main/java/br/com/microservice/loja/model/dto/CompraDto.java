package br.com.microservice.loja.model.dto;

import java.util.List;

import lombok.Data;

@Data
public class CompraDto {

	private List<ItemDaCompraDto> itens;
	private EnderecoDto endereco;
}
