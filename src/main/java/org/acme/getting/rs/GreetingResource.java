package org.acme.getting.rs;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @Inject
    AllExceptions allExceptions;

    @GET
    @Path("/1")
    @Produces(MediaType.APPLICATION_JSON)
    public String hello() throws Exception {
        throw allExceptions.simpleException();
    }

    @GET
    @Path("/2")
    @Produces(MediaType.APPLICATION_JSON)
    public String hello2() throws Exception {
        throw allExceptions.completeException();
    }
}