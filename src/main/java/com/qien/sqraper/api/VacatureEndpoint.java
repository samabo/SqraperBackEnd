package com.qien.sqraper.api;

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
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qien.sqraper.domain.Vacature;
import com.qien.sqraper.persistence.SqraperService;

@Component
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("vacature")
public class VacatureEndpoint {

	@Autowired
	private SqraperService sqraperService;

	// get put post delete voor vacatures
	@GET
	public Response listGroupVacature() {
		Iterable<Vacature> iterable = sqraperService.findAllVacatures();
		return (Response.ok(iterable).build());
	}

	@GET
	@Path("{id}")
	public Response findVacature(@PathParam("id") long id) {
		System.out.println("Start" + id);
		Vacature vacature = sqraperService.findVacatureById(id); // findById
		System.out.println(vacature);

		if (vacature == null) {
			return Response.accepted(Status.GONE).build();
		}
		return (Response.ok(vacature).build());
	}

	@PUT
	@Path("{id}")
	public Response updateVacature(@PathParam("id") Long id, Vacature vacature) {
		Vacature result = sqraperService.findVacatureById(id);
		if (result == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		System.out.println("FOUND");

		if (vacature.getId() != result.getId()) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		boolean changed = false;

		if (!vacature.getTitel().equals("")) {
			if (!vacature.getTitel().equals(result.getTitel())) {
				changed = true;
			} else {
				vacature.setTitel(result.getTitel());
			}
		}

		if (!vacature.getOmschrijving().equals("")) {
			if (!vacature.getOmschrijving().equals(result.getOmschrijving())) {
				changed = true;
			} else {
				vacature.setOmschrijving(result.getOmschrijving());
			}
		}

		if (!vacature.getPlaats().equals("")) {
			if (!vacature.getPlaats().equals(vacature.getPlaats())) {
				changed = true;
			} else {
				vacature.setPlaats(result.getPlaats());
			}
		}

		if (!(vacature.getKeywords() == null)) {
			if (!vacature.getKeywords().equals(result.getKeywords())) {
				changed = true;
			} else {
				vacature.setKeywords(result.getKeywords());
			}
		}
		
		if (vacature.getVacatureLink() != null && !vacature.getVacatureLink().equals("")) {
			if (!vacature.getVacatureLink().equals(vacature.getVacatureLink())) {
				changed = true;
			} else {
				vacature.setVacatureLink(result.getVacatureLink());
			}
		}

		if (vacature.getStudenten() != null && !vacature.getStudenten().equals(vacature.getStudenten())) {
			changed = true;
		} else {
			vacature.setStudenten(result.getStudenten());
		}

		if (changed) {
			sqraperService.save(vacature);
			return Response.ok(vacature).build();
		} else {
			return Response.notModified().build();
		}
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response postVacature(Vacature vacature) {
		Vacature result = sqraperService.save(vacature);
		return (Response.accepted(result.getId()).build());
	}

	@DELETE
	@Path("{id}")
	public Response deleteVacature(@PathParam("id") Long id) {
		Vacature result = sqraperService.findVacatureById(id);
		if (result == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		sqraperService.deleteById(id);
		return Response.accepted().build();
	}

}
