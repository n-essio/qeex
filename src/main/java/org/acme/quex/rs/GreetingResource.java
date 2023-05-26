package org.acme.quex.rs;

import org.acme.quex.enums.AcmeQeexExceptions;
import org.acme.quex.exception.ExceptionBundle;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @Inject
    ExceptionBundle exceptionBundle;

    @GET
    @Path("/1")
    @Produces(MediaType.APPLICATION_JSON)
    public String hello() throws Exception {
        throw AcmeQeexExceptions.DUE.get();
        // throw exceptionBundle.simpleException();
    }

    @GET
    @Path("/2")
    @Produces(MediaType.APPLICATION_JSON)
    public String hello2() throws Exception {
        throw exceptionBundle.completeException();
    }

    @GET
    @Path("/3")
    @Produces(MediaType.APPLICATION_JSON)
    public String hello3() throws Exception {
        throw exceptionBundle.notOverrideException();
    }

    @GET
    @Path("/4")
    @Produces(MediaType.APPLICATION_JSON)
    public String hello4() throws Exception {
        throw new Exception("bohhh");
    }

    @GET
    @Path("/5")
    @Produces(MediaType.APPLICATION_JSON)
    public String hello5() throws Exception {
        throw exceptionBundle.withArguments(".one.", ".two.");
    }
}
