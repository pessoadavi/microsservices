package br.com.alura.microservice.transportador.service;

import br.com.alura.microservice.transportador.dto.EntregaDto;
import br.com.alura.microservice.transportador.dto.VoucherDto;

public interface EntregaService {

	VoucherDto reservaEntrega(EntregaDto pedidoDTO);
}
