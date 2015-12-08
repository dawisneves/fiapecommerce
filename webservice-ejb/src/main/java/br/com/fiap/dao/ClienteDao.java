package br.com.fiap.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import br.com.fiap.interfaces.ClienteLocal;
import br.com.fiap.model.Cliente;

@Stateless
public class ClienteDao implements ClienteLocal {
	
	public static List<Cliente> clientes = new ArrayList<Cliente>();
	private static Cliente cliente;
	
	public ClienteDao() {
		if(!(cliente instanceof Object)) {
			cliente = new Cliente();
			cliente.setCodigo(1);
			cliente.setCpf("123456789");
			cliente.setEndereco("rua teste,12");
			cliente.setNome("Joao");
			cliente.setRg("22200003333");
			cliente.setSituacao("liberado");
			cliente.setTelefone("1122336699");
			clientes.add(cliente);
		}
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public List<Cliente> listar() {
		return clientes;
	}
	
	public void adicionar(Cliente c) {
		clientes.add(c);
	}
	
	public void atualizar(Cliente c) {
		
		for (Cliente cli : clientes) {  
	        if (cli.getCodigo() == c.getCodigo()) {  
	        	clientes.remove(cli);
	        	clientes.add(c);
	        }  
	    }		
	}
	
	public void remover(int id) {
		
		for (Cliente cli : clientes) {  
	        if (cli.getCodigo() == id) {  
	        	cliente.setCodigo(id);
	        	clientes.remove(cliente);        	
	        }  
	    }  
	}

}
