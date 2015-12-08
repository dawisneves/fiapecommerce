package br.com.fiap.app;
import br.com.fiap.dao.CompraDao;
import br.com.fiap.dao.ProdutoDao;
import br.com.fiap.dao.ReservaDao;
import br.com.fiap.model.Cliente;
import br.com.fiap.model.Compra;
import br.com.fiap.model.Produto;


public class Teste {
	public static void main(String[] args) {
		ReservaDao reservaDao = new ReservaDao();
		
		for (Cliente cliente : reservaDao.listarClientes()) {
			System.out.println(cliente.getCodigo() + "\n" + cliente.getNome());
		}
		
		CompraDao compraDao = new CompraDao();
		
		 for (Compra compra : compraDao.listarMaior500()) {
			System.out.println(compra.getNumero());
		}
		 
		ProdutoDao produtoDao = new ProdutoDao();
		
		 for (Produto produto : produtoDao.listaProdutoMenor1000()) {
			System.out.println(produto.getCodigo());
		}
	}
}
