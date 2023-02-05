package com.openbootcamp.demo.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.stereotype.Component;

import com.openbootcamp.demo.models.Bootcamper;
import com.openbootcamp.demo.services.BootcamperService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Component
@Path("/")
public class RestcampersController {

	private BootcamperService bootcamperService;
	
	public RestcampersController(BootcamperService camperService) {
		this.bootcamperService = camperService;
		
		this.bootcamperService.add(new Bootcamper("Luis"));
		this.bootcamperService.add(new Bootcamper("Maria"));
		this.bootcamperService.add(new Bootcamper("Jesus"));
		this.bootcamperService.add(new Bootcamper("Jose"));
		this.bootcamperService.add(new Bootcamper("Ana"));
		
	}
	
	@GET
	@Path("/bootcampers")
	@Produces("application/json")
	public List<Bootcamper> listarTodos() {
		return this.bootcamperService.getAll();
	}
	
	@GET
	public String hola() {
		return "Bienvenid@";
	}
	
	@POST
	@Path("/bootcampers")
	@Produces("application/json")
	@Consumes("application/json")
	public Response meterBootcamper(Bootcamper bootcamper) {
		this.bootcamperService.add(bootcamper);
		return Response.created(URI.create("/bootcampers/" + bootcamper.getNombre())).build();
	}
	
	@GET
	@Path("/bootcampers/{nombre}")
	@Produces("application/json")
	public Bootcamper listarUno(@PathParam("nombre") String nombre) {
		return this.bootcamperService.get(nombre);
	}
	
}
