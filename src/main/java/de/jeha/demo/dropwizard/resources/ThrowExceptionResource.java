package de.jeha.demo.dropwizard.resources;


import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class ThrowExceptionResource {

    @GET
    @Path("/throwException")
    @Timed
    public String hello() {
        throw new RuntimeException("This exception was thrown by intention!");
    }

}