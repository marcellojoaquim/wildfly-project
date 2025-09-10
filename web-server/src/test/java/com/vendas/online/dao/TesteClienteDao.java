package com.vendas.online.dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Assert;
import org.junit.Test;

import com.vendas.online.domain.Cliente;
import com.vendas.online.exceptions.DaoException;

public class TesteClienteDao {
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	IClienteDao dao = new ClienteDao();
	
	@Test
	public void cadastrar() throws DaoException {
	
		Cliente cliente = new Cliente();
		cliente.setNome("Teste Nome");
		cliente.setCpf(12345678900L);
		cliente.setTel(9999999999L);
		cliente.setEmail("email@email.com");
		cliente.setEnd("End teste");
		cliente.setEstado("Estado teste");
		cliente.setCidade("Cidade teste");
		cliente.setNumero(123);
		
		Cliente result = dao.cadastrar(cliente);
		Assert.assertNotNull(result);
	}
	
}
