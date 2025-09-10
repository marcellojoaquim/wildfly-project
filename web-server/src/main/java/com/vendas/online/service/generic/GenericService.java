package com.vendas.online.service.generic;

import java.io.Serializable;
import java.util.Collection;

import com.vendas.online.dao.generic.IGenericDao;
import com.vendas.online.domain.Persistente;
import com.vendas.online.exceptions.DaoException;
import com.vendas.online.exceptions.MaisDeUmRegistroException;


public class GenericService<T extends Persistente, E extends Serializable> implements IGenericDao<T, E> {
	
	protected IGenericDao<T, E> dao;
	
	public GenericService(IGenericDao<T, E> dao) {
		this.dao = dao;
	}

	@Override
	public T cadastrar(T entity) throws DaoException {
		return this.dao.cadastrar(entity);
	}

	@Override
	public void excluir(T entity) throws DaoException {
		this.dao.excluir(entity);
		
	}

	@Override
	public T alterar(T entity) throws DaoException {
		return this.dao.alterar(entity);
	}

	@Override
	public T consultar(E id) throws MaisDeUmRegistroException, DaoException {
		return this.dao.consultar(id);
	}

	@Override
	public Collection<T> buscarTodos() throws DaoException {
		return this.dao.buscarTodos();
	}

}
