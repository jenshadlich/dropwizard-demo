package de.jeha.demo.dropwizard.resources;


import com.codahale.metrics.annotation.Timed;
import de.jeha.demo.dropwizard.api.VersionResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Path("/")
public class VersionResource {

    private final static DateFormat BUILD_TIME_FORMAT = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

    @GET
    @Path("/version")
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    public Response version() {

        return Response.ok(new VersionResponse("dropwizard-demo", "", BUILD_TIME_FORMAT.format(new Date()), "")).build();
    }

}