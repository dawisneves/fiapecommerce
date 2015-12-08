package br.com.fiap.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private BigInteger codigo;
	private String descricao;
	private BigDecimal preco;
	private String estoque;
	
	public BigInteger getCodigo() {
		return codigo;
	}
	public void setCodigo(BigInteger codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public String getEstoque() {
		return estoque;
	}
	public void setEstoque(String estoque) {
		this.estoque = estoque;
	}

}
