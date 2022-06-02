package br.com.microservice.loja.model.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import br.com.microservice.loja.enums.CompraStateEnum;
import lombok.Data;

@Data
@Entity
public class CompraEntity {

	@Id
	private Long pedidoId;

	private Integer tempoDePreparo;

	private String enderecoDestino;

	private LocalDate dataParaEntrega;

	private Long voucher;
	
	@Enumerated(EnumType.STRING)
	private CompraStateEnum state;
}
