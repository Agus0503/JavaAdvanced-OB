package com.example.demo.controllers;

import com.example.demo.models.Bootcamper;
import com.example.demo.services.BootcamperService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.List;

@Component
@Path("/")
public class bootcampersController {

    private final BootcamperService bootcamperService;

    public bootcampersController(BootcamperService bootcamperService) {
        this.bootcamperService = bootcamperService;
        this.bootcamperService.add(new Bootcamper("Agus", Math.random()));
        this.bootcamperService.add(new Bootcamper("Victor", Math.random()));
        this.bootcamperService.add(new Bootcamper("Alan", Math.random()));
    }

    @GET
    @Path("/bootcampers")
    @Produces("application/json")
    public List<Bootcamper> listAll() { return bootcamperService.getAll(); }

    @GET
    @Path("/bootcampers/{nombre}")
    @Produces("application/json")
    public Bootcamper listOne(@PathParam("nombre") String name) { return bootcamperService.get(name); }

    @POST
    @Path("/bootcampers/post")
    @Produces("application/json")
    @Consumes("application/json")
    public Response addBootcamper(Bootcamper bootcamper) {
        bootcamperService.add(bootcamper);
        return Response.created(URI.create("/bootcampers/" + bootcamper.getName())).build();
    }

    @DELETE
    @Path("/bootcampers/{name}/delete")
    @Produces("application/json")
    public Response deleteBootcamper(@PathParam("name") String name){
        Bootcamper bootcamper = bootcamperService.findByName(name);
        if (bootcamper != null) {
            bootcamperService.remove(bootcamper);
            return Response.ok().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Path("/bootcampers/{name}/update")
    @Produces("application/json")
    @Consumes("application/json")
    public Response updateBootcamper(@PathParam("name") String name, Bootcamper updatedBootcamper){

        Bootcamper bootcamper = bootcamperService.update(name, updatedBootcamper.getValue());
        if (bootcamper != null) {
            bootcamper.setName(updatedBootcamper.getName());
            return Response.ok(bootcamper).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
