package io.quarkus.qeex.api.rs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.qeex.api.exceptions.QeexWebException;

import javax.inject.Inject;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class QuarkusWebExceptionProvider implements ExceptionMapper<QeexWebException> {

    @Context
    UriInfo uriInfo;

    @Inject
    ObjectMapper objectMapper;

    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public Response toResponse(QeexWebException exception) {
//        exception.printStackTrace();
        String jsonStr = "";
        String language = uriInfo.getQueryParameters().getFirst("language");
        try {
            jsonStr = objectMapper.writeValueAsString(exception.msg(language));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return Response
                .status(exception.httpCode)
                .entity(jsonStr)
                .build();
    }
}