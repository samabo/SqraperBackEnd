package com.qien.sqraper.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.qien.sqraper.domain.Vacature;
import com.qien.sqraper.persistence.SqraperService;

@Component
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("lid")
public class SqraperEndpoint {
	
	@Autowired
	private SqraperService sqraperService;
	
	
	@GET
	public Response listGroup() {
//		System.out.println("In GET");
		Iterable<Vacature> iterable = sqraperService.findAll();
		return (Response.ok(iterable).build());
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response postLid(Vacature vacature) {
//		System.out.println("test post" + lid.getId() + lid.getNaam());
		Vacature result = sqraperService.saveVacature(vacature);
		return (Response.accepted(result.getId()).build());
	}
}
