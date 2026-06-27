package com.vendas.online.service;



import com.vendas.online.domain.Cliente;
import com.vendas.online.exceptions.DaoException;
import com.vendas.online.service.generic.IGenericService;

public interface IClienteService extends IGenericService<Cliente, Long> {
	
	Cliente buscarPorCpf(Long cpf) throws DaoException;

}
