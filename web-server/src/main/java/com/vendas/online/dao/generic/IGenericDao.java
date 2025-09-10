package com.vendas.online.dao.generic;

import java.io.Serializable;
import java.util.Collection;

import com.vendas.online.domain.Persistente;
import com.vendas.online.exceptions.DaoException;
import com.vendas.online.exceptions.MaisDeUmRegistroException;


public interface IGenericDao<T extends Persistente, E extends Serializable>{
	
	public T cadastrar(T entity) throws DaoException;

    public void excluir(T entity) throws DaoException;

    public T alterar(T entity) throws DaoException;

    public T consultar(E id) throws MaisDeUmRegistroException, DaoException;

    public Collection<T> buscarTodos() throws DaoException;

}
