package br.com.fiap.dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import br.com.fiap.interfaces.ProdutoLocal;
import br.com.fiap.model.Produto;

@Stateless
public class ProdutoDao implements ProdutoLocal {
	
	public static List<Produto> produtos = new ArrayList<Produto>();
	private static Produto produto;
	
	public ProdutoDao() {
		if(!(produto instanceof Object)) {
			produto = new Produto();
			produto.setCodigo(new BigInteger("1"));
			produto.setDescricao("mouse");
			produto.setEstoque("10");
			produto.setPreco(new BigDecimal("3000.0"));
			produtos.add(produto);
			
			Produto p = new Produto(); 
			p.setCodigo(new BigInteger("2"));
			p.setDescricao("teclado");
			p.setEstoque("5");
			p.setPreco(new BigDecimal("30.0"));
			produtos.add(p);
		}
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public List<Produto> listaProdutoMenor1000() {
		List<Produto> lsProduto = new ArrayList<Produto>();
		
		for (Produto prod : produtos) {
			if(prod.getPreco().doubleValue() < 1000.0) {
				lsProduto.add(prod);
			}
		}
		
		return lsProduto;
	}
	
	public List<Produto> listar() {
		return produtos;
	}
	
	public void adicionar(Produto c) {	
		produtos.add(c);
	}
	
	public void atualizar(Produto c) {
		
		for (Produto pro : produtos) {  
	        if (pro.getCodigo().equals(c.getCodigo())) {  
	        	produtos.remove(pro);
	        	produtos.add(c);
	        }  
	    }		
	}
	
	public void remover(int id) {
		
		for (Produto pro : produtos) {  
	        if (pro.getCodigo().equals(id)) {
	        	produtos.remove(pro);        	
	        }  
	    }  
	}
}
