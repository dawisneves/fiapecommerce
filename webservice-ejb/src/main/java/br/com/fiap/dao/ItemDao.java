package br.com.fiap.dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import br.com.fiap.model.Item;

@Stateless
public class ItemDao {
	
	public static List<Item> itens = new ArrayList<Item>();
	private static Item item;
	
	public ItemDao() {
		if(!(item instanceof Object)) {
			item = new Item();
			CompraDao compra = new CompraDao();
			item.setCompra(compra.getCompra());
			ProdutoDao produto = new ProdutoDao();
			item.setProduto(produto.getProduto());
			item.setQuantidade(new BigInteger("2"));
			ReservaDao reserva = new ReservaDao();
			item.setReserva(reserva.getReserva());
			item.setSituacao("ABERTO");
			item.setValor(new BigDecimal("30"));
			itens.add(item);
		}
	}
	
	public Item getItem() {
		return item;
	}
	
	public List<Item> listar() {
		return itens;
	}
	
	public void adicionar(Item c) {
		itens.add(c);
	}
	
	
	public void remover(Item item) {
		itens.remove(item);
	}
}
