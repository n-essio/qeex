package io.quarkus.qeex.api.rs;

import io.quarkus.qeex.api.exceptions.QeexWebException;
import io.quarkus.qeex.api.interceptors.LanguageInterceptor;

import javax.inject.Inject;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class QuarkusWebExceptionProvider implements ExceptionMapper<QeexWebException> {

    @Inject
    LanguageInterceptor languageInterceptor;

    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public Response toResponse(QeexWebException exception) {
        var language = languageInterceptor.getLanguage();
        return Response
                .status(exception.httpCode)
                .entity(exception.toJson())
                .build();
    }
}
