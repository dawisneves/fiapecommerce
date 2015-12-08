package br.com.fiap.bean;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;

import br.com.fiap.interfaces.ProdutoLocal;
import br.com.fiap.model.Produto;


@Path("/produto")
public class ProdutoBean {
	
	@EJB
    private ProdutoLocal produtoLocal;
	
	Produto vProduto = new Produto();
	ObjectMapper mapper = new ObjectMapper();
	
	@GET
	@Path("/")
	@Produces("application/json")
	public List<Produto> list() {
		return produtoLocal.listar();
	}
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public List<Produto> listar1000(@PathParam("id") Integer id) {
		return produtoLocal.listaProdutoMenor1000();
	}
	
	
	@Path("/")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(String produto) {

			try {
				 JsonParser jsonParser = mapper.getJsonFactory().createJsonParser(produto);
				 JsonNode tree = jsonParser.readValueAsTree();
				 vProduto = mapper.treeToValue(tree, Produto.class);
				 produtoLocal.adicionar(vProduto);	
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return Response.status(201).entity("Criado com sucesso").build();
	}
	
	@Path("/")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(String produto) {
			try {
				JsonParser jsonParser = mapper.getJsonFactory().createJsonParser(produto);
				JsonNode tree = jsonParser.readValueAsTree();
				vProduto = mapper.treeToValue(tree, Produto.class);
				produtoLocal.atualizar(vProduto);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return Response.status(201).entity("Alterado com sucesso").build();
	}
	
	@Path("/{id}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") Integer id) {
			try {
				produtoLocal.remover(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return Response.status(201).entity("Excluido com sucesso").build();
	}
	
}
