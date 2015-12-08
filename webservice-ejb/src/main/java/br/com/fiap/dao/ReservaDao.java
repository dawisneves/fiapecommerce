package br.com.fiap.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import br.com.fiap.interfaces.ReservaLocal;
import br.com.fiap.model.Cliente;
import br.com.fiap.model.Reserva;

@Stateless
public class ReservaDao implements ReservaLocal {
	
	public static List<Reserva> reservas = new ArrayList<Reserva>();
	private static Reserva reserva;
	
	public ReservaDao() {
		if(!(reserva instanceof Object)) {
			reserva = new Reserva();
			reserva.setCodigo(1);
			reserva.setAtendente("Ana");
			reserva.setData(new Date());
			ClienteDao clienteDao = new ClienteDao();
			reserva.setCliente(clienteDao.getCliente());
			reserva.setSituacao("ABERTO");
			reserva.setValor(new BigDecimal("40.0"));
			reservas.add(reserva);
		}
	}
	
	public Reserva getReserva() {
		return reserva;
	}
	
	public List<Cliente> listarClientes() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		clientes.add(reserva.getCliente());
		return clientes;
	}
	
	public List<Reserva> listar() {
		return reservas;
	}
	
	public void adicionar(Reserva c) {
		reservas.add(c);
	}
	
	public void atualizar(Reserva c) {
		
		for (Reserva res : reservas) {  
	        if (res.getCodigo() == c.getCodigo()) {  
	        	reservas.remove(res);
	        	reservas.add(c);
	        }  
	    }		
	}
	
	public void remover(int id) {
		
		for (Reserva res : reservas) {  
	        if (res.getCodigo() == id) {
	        	reservas.remove(res);        	
	        }  
	    }  
	}
	
	
}
