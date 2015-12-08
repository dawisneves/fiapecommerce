package br.com.fiap.interfaces;

import java.util.List;

import javax.ejb.Local;

import br.com.fiap.model.Compra;

@Local
public interface CompraLocal {
	
	List<Compra> listar();
	void adicionar(Compra compra);
	void atualizar(Compra compra);
	void remover(int id);
	Compra getCompra();
	List<Compra> listarMaior500();
	
}
