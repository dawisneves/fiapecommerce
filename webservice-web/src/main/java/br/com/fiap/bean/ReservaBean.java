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

import br.com.fiap.interfaces.ReservaLocal;
import br.com.fiap.model.Cliente;
import br.com.fiap.model.Reserva;


@Path("/reserva")
public class ReservaBean {
	
	@EJB
    private ReservaLocal reservaLocal;
		
	Reserva vReserva = new Reserva();
	ObjectMapper mapper = new ObjectMapper();
	
	@GET
	@Path("/")
	@Produces("application/json")
	public List<Reserva> list() {
		return reservaLocal.listar();
	}
		
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public List<Cliente> listarCliente(@PathParam("id") Integer id) {
		return reservaLocal.listarClientes();
	}
	
	@Path("/")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(String compra) {

			try {
				 JsonParser jsonParser = mapper.getJsonFactory().createJsonParser(compra);
				 JsonNode tree = jsonParser.readValueAsTree();
				 vReserva = mapper.treeToValue(tree, Reserva.class);
				 reservaLocal.adicionar(vReserva);
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
				vReserva = mapper.treeToValue(tree, Reserva.class);
				reservaLocal.atualizar(vReserva);
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
				reservaLocal.remover(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return Response.status(201).entity("Excluido com sucesso").build();
	}
	
}
