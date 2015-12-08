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

import br.com.fiap.interfaces.CompraLocal;
import br.com.fiap.model.Compra;


@Path("/compra")
public class CompraBean {
	
	@EJB
    private CompraLocal compraLocal;
		
	Compra vCompra = new Compra();
	ObjectMapper mapper = new ObjectMapper();
	
	@GET
	@Path("/")
	@Produces("application/json")
	public List<Compra> list() {
		return compraLocal.listar();
	}
		
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public List<Compra> listar500(@PathParam("id") Integer id) {
		return compraLocal.listarMaior500();
	}
	
	@Path("/")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(String compra) {

			try {
				 JsonParser jsonParser = mapper.getJsonFactory().createJsonParser(compra);
				 JsonNode tree = jsonParser.readValueAsTree();
				 vCompra = mapper.treeToValue(tree, Compra.class);
				 compraLocal.adicionar(vCompra);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return Response.status(201).entity("Criado com sucesso").build();
	}
	
	@Path("/")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(String compra) {
			try {
				JsonParser jsonParser = mapper.getJsonFactory().createJsonParser(compra);
				JsonNode tree = jsonParser.readValueAsTree();
				vCompra = mapper.treeToValue(tree, Compra.class);
				compraLocal.atualizar(vCompra);
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
				compraLocal.remover(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return Response.status(201).entity("Excluido com sucesso").build();
	}
	
}
