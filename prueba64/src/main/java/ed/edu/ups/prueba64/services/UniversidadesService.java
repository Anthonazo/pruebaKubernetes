package ed.edu.ups.prueba64.services;

import java.util.List;

import ed.edu.ups.prueba64.bussines.GestionUniversidades;
import ed.edu.ups.prueba64.dao.UniversidadesDAO;
import ed.edu.ups.prueba64.model.Universidades;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("crud")
public class UniversidadesService {

	@Inject
	private GestionUniversidades gUniversidades;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear(Universidades u) {
		try {
			gUniversidades.save(u);
			ErrorMessage error = new ErrorMessage(1, "OK");
			return Response.ok(error).build();
		} catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build();
		}
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizar(Universidades u) {
		try {
			gUniversidades.put(u);
			ErrorMessage error = new ErrorMessage(1, "OK");
			return Response.ok(error).build();
		} catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.NOT_FOUND).entity(error).build();
		}
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response borrar(@QueryParam("id") int codigo) {
		try {
			gUniversidades.remove(codigo);
			ErrorMessage error = new ErrorMessage(1, "OK");
			return Response.ok(error).build();
		} catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.NOT_FOUND).entity(error).build();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("list")
	public Response getall() {
		try {
			List<Universidades> universidades = gUniversidades.getall();
			return Response.ok(universidades).build();
		} catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.NOT_FOUND).entity(error).build();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getU(@QueryParam("id") int codigo) {
		try {
			Universidades universidades = gUniversidades.getU(codigo);
			return Response.ok(universidades).build();
		} catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.NOT_FOUND).entity(error).build();
		}
	}
}
