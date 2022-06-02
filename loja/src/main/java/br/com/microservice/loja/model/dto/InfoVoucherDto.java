package br.com.microservice.loja.model.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class InfoVoucherDto {

	private Long numero;

	private LocalDate previsaoParaEntrega;
}
