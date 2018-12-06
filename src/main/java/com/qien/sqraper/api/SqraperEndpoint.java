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

import com.qien.sqraper.domain.Student;
import com.qien.sqraper.persistence.SqraperService;

@Component
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("sqraper")
public class SqraperEndpoint {

	@Autowired
	private SqraperService sqraperService;

	@GET
	@Path("allStudents")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listGroup() {
		Iterable<Student> iterable = sqraperService.findAllStudents();
		return (Response.ok(iterable).build());
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findStudent(@PathParam("id") long id) {
		Student student = sqraperService.findStudentById(id); // findById
		if (student == null) {
			return Response.accepted(Status.GONE).build();
		}
		return (Response.ok(student).build());
	}

	@PUT 
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateStudent(@PathParam("id") Long id, Student student) {
		Student result = sqraperService.findStudentById(id);
		if (result == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		System.out.println("FOUND");

		if (student.getId() != result.getId()) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		boolean changed = false;

		if (!student.getVoornaam().equals("")) {
			if (!student.getVoornaam().equals(result.getVoornaam())) {
				changed = true;

			} else {
				student.setVoornaam(result.getVoornaam());
			}
		}

		if (!student.getVoorvoegsel().equals("")) {
			if (!student.getVoorvoegsel().equals(result.getVoorvoegsel())) {
				changed = true;

			} else {
				student.setVoorvoegsel(result.getVoorvoegsel());
			}
		}

		if (!student.getAchternaam().equals("")) {
			if (!student.getVoornaam().equals(result.getVoornaam())) {
				changed = true;

			} else {
				student.setAchternaam(result.getAchternaam());
			}
		}
		if (!student.getTelefoonnummer().equals("")) {
			if (!student.getTelefoonnummer().equals(result.getTelefoonnummer())) {
				changed = true;
			} else {
				student.setTelefoonnummer(result.getTelefoonnummer());
			}
		}

		if (!student.getEmailadres().equals("")) {
			if (!student.getEmailadres().equals(result.getEmailadres())) {
				changed = true;

			} else {
				student.setEmailadres(result.getEmailadres());
			}
		}

		if (!student.getWoonplaats().equals("")) {
			if (!student.getWoonplaats().equals(result.getWoonplaats())) {
				changed = true;

			} else {
				student.setWoonplaats(result.getWoonplaats());
			}
		}

//		if (!student.getKeywords().equals("")) {
//			if (!student.getKeywords().equals(result.getKeywords())) {
//				changed = true;
//
//			} else {
//				student.setKeywords(result.getKeywords());
//			}
//		}
//
//		if (!student.getGelinkteVacatures().equals("")) {
//			if (!student.getGelinkteVacatures().equals(result.getGelinkteVacatures())) {
//				changed = true;
//
//			} else {
//				student.setGelinkteVacatures(result.getGelinkteVacatures());
//			}
//		}

		if (changed) {
			sqraperService.saveStudent(student);
			return Response.ok(student).build();
		} else {
			return Response.notModified().build();
		}
	}

	@POST
	@Path("{AddStudent}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response postStudent(Student student) {
		Student result = sqraperService.saveStudent(student);
		return (Response.accepted(result.getId()).build());
	}

	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteStudent(@PathParam("id") Long id) {
		Student result = sqraperService.findStudentById(id);
		if (result == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		sqraperService.deleteStudentById(id);
		return Response.accepted().build();
	}

	

}
