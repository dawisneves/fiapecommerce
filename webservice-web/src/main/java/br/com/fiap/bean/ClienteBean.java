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

import br.com.fiap.interfaces.ClienteLocal;
import br.com.fiap.model.Cliente;


@Path("/cliente")
public class ClienteBean {
	
	@EJB
    private ClienteLocal clienteLocal;
		
	Cliente vCliente = new Cliente();
	ObjectMapper mapper = new ObjectMapper();
	
	@GET
	@Path("/")
	@Produces("application/json")
	public List<Cliente> list() {
		return clienteLocal.listar();
	}
		
	@Path("/")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(String cliente) {

			try {
				 JsonParser jsonParser = mapper.getJsonFactory().createJsonParser(cliente);
				 JsonNode tree = jsonParser.readValueAsTree();
				 vCliente = mapper.treeToValue(tree, Cliente.class);
				 clienteLocal.adicionar(vCliente);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return Response.status(201).entity("Criado com sucesso").build();
	}
	
	@Path("/")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(String cliente) {
			try {
				JsonParser jsonParser = mapper.getJsonFactory().createJsonParser(cliente);
				JsonNode tree = jsonParser.readValueAsTree();
				vCliente = mapper.treeToValue(tree, Cliente.class);
				clienteLocal.atualizar(vCliente);
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
				clienteLocal.remover(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return Response.status(201).entity("Excluido com sucesso").build();
	}
	
}
