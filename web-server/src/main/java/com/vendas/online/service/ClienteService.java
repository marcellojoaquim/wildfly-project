package com.vendas.online.service;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.vendas.online.dao.IClienteDao;
import com.vendas.online.domain.Cliente;
import com.vendas.online.exceptions.DaoException;
import com.vendas.online.exceptions.MaisDeUmRegistroException;
import com.vendas.online.service.generic.GenericService;

@Transactional
@ApplicationScoped
public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {

	@Inject
	public ClienteService(IClienteDao clienteDao) {
		super(clienteDao);
	}

	@Override
	public Cliente buscarPorCpf(Long cpf) throws DaoException {
		try {
			return this.dao.consultar(cpf);
		} catch (MaisDeUmRegistroException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

}
