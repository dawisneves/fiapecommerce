package br.com.fiap.dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import br.com.fiap.interfaces.CompraLocal;
import br.com.fiap.model.Compra;

@Stateless
public class CompraDao implements CompraLocal {
	
	public static List<Compra> compras = new ArrayList<Compra>();
	private static Compra compra;
	
	public CompraDao() {
		if(!(compra instanceof Object)) {
			compra = new Compra();
			compra.setNumero(new BigInteger("1000"));
			compra.setData(new Date());
			ClienteDao clienteDao = new ClienteDao();
			compra.setCliente(clienteDao.getCliente());
			ReservaDao reserva = new ReservaDao();
			compra.setReserva(reserva.getReserva());
			compra.setResponsavel("Claudio");
			compra.setSituacao("PEDIDO");
			compra.setValor(new BigDecimal("501"));
			compras.add(compra);
		}
	}
	
	public Compra getCompra() {
		return compra;
	}
	
	public List<Compra> listarMaior500() {
		List<Compra> lsCompra = new ArrayList<Compra>();
		
		for (Compra comp : compras) {
			if(comp.getValor().doubleValue() > 500.0) {
				lsCompra.add(comp);
			}
		}
		return lsCompra;
	}
	
	public List<Compra> listar() {
		return compras;
	}
	
	public void adicionar(Compra c) {
		compras.add(c);
	}
	
	public void atualizar(Compra c) {
		
		for (Compra com : compras) {  
	        if (com.getNumero().equals(c.getNumero())) {  
	        	compras.remove(com);
	        	compras.add(c);
	        }  
	    }		
	}
	
	public void remover(int id) {
		
		for (Compra com : compras) {  
	        if (com.getNumero().equals(id)) {
	        	compras.remove(com);        	
	        }  
	    }  
	}

}
