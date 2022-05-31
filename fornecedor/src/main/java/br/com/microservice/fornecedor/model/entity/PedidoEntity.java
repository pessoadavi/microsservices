package br.com.microservice.fornecedor.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import br.com.microservice.fornecedor.enums.PedidoStatusEnum;
import lombok.Data;

@Data
@Entity
public class PedidoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private PedidoStatusEnum status;
	
	private Integer tempoDePreparo;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "pedidoId")
	private List<PedidoItemEntity> itens;
	
	public PedidoEntity(List<PedidoItemEntity> itens) {
		this.itens = itens;
		this.status = PedidoStatusEnum.RECEBIDO;
	}
	
	public PedidoEntity() {
	}
}
