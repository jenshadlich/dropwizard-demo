package de.jeha.demo.dropwizard.resources;


import com.codahale.metrics.annotation.Timed;
import de.jeha.demo.dropwizard.api.HelloResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class HelloResource {

    private static final Logger LOG = LoggerFactory.getLogger(HelloResource.class);

    private final String message;

    public HelloResource(String message) {
        this.message = message;
    }

    @GET
    @Path("/hello")
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    public Response hello() {
        LOG.info("hello()");

        return Response.ok(new HelloResponse(message)).build();
    }

}