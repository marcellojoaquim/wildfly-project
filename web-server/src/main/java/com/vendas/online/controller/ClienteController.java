package com.vendas.online.controller;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.vendas.online.domain.Cliente;
import com.vendas.online.exceptions.DaoException;
import com.vendas.online.service.IClienteService;

@Named
@ViewScoped
public class ClienteController implements Serializable{

	private static final long serialVersionUID = -7716112622833630169L;
	
	private Cliente cliente;
	
	private Collection<Cliente> clientes;
	
	@Inject
	private IClienteService clienteService;
	
	private Boolean isUpdate;
	
	@PostConstruct
	public void init() {
		try {
			this.isUpdate = false;
			this.cliente = new Cliente();
			this.clientes = clienteService.buscarTodos();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage());
		}
	}
	
	public void add() {
		try {
			clienteService.cadastrar(cliente);
			this.clientes = clienteService.buscarTodos();
			this.cliente = new Cliente();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar criar o cliente"));
		}
	}
	
	public void delete(Cliente cliente) {
		try {
			clienteService.excluir(cliente);
			this.clientes = clienteService.buscarTodos();
			this.cliente = new Cliente();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar excluir o cliente"));
		}
	}
	
	public Cliente edit(Cliente novoCliente) {
		try {
			this.cliente = novoCliente;
			setIsUpdate(true);
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar excluir o cliente"));
		}
		return cliente;
	}
	
	public void update() throws DaoException {
		if(getIsUpdate()) {
			isUpdate = false;
			clienteService.alterar(this.cliente);
			setIsUpdate(isUpdate);
			this.clientes = clienteService.buscarTodos();
			this.cliente = new Cliente();
		}
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Collection<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Collection<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Boolean getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(Boolean isUpdate) {
		this.isUpdate = isUpdate;
	}
	
	

}
