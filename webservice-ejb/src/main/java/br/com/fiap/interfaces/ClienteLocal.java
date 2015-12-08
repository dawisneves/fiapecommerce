package br.com.fiap.interfaces;

import java.util.List;

import javax.ejb.Local;

import br.com.fiap.model.Cliente;

@Local
public interface ClienteLocal {
	
	List<Cliente> listar();
	void adicionar(Cliente cliente);
	void atualizar(Cliente cliente);
	void remover(int id);
	Cliente getCliente();
	
}
