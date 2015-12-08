package br.com.fiap.interfaces;

import java.util.List;

import javax.ejb.Local;

import br.com.fiap.model.Produto;

@Local
public interface ProdutoLocal {
	
	List<Produto> listar();
	void adicionar(Produto produto);
	void atualizar(Produto produto);
	void remover(int id);
	Produto getProduto();
	List<Produto> listaProdutoMenor1000();
	
}
