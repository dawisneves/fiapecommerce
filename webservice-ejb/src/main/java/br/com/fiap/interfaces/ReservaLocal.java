package br.com.fiap.interfaces;

import java.util.List;

import javax.ejb.Local;

import br.com.fiap.model.Cliente;
import br.com.fiap.model.Reserva;

@Local
public interface ReservaLocal {
	
	List<Reserva> listar();
	void adicionar(Reserva reserva);
	void atualizar(Reserva reserva);
	void remover(int id);
	Reserva getReserva();
	List<Cliente> listarClientes();
	
}
