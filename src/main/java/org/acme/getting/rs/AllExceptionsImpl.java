package org.acme.getting.rs;

import io.quarkus.qeex.api.annotations.QeexConfig;
import io.quarkus.qeex.api.exceptions.QeexWebException;
import io.quarkus.qeex.api.interceptors.LanguageInterceptor;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class AllExceptionsImpl implements AllExceptions {

    String classProjectName = "FLW";

    @Inject
    QeexConfig qeexConfig;

    @Inject
    LanguageInterceptor languageInterceptor;

    @Override
    public QeexWebException simpleException() {
        // from annotation  @QeexMessage(message = "prova")
        int _id = 101;
        Integer code = null;
        String message = "prova";
        String language = null;
        return new QeexWebException(qeexConfig.get_project(classProjectName),
                _id,
                qeexConfig.get_code(_id, code),
                qeexConfig.get_message(_id, message, languageInterceptor.getLanguage()),
                qeexConfig.get_language(_id, language));
    }

    @Override
    public QeexWebException completeException() {
        // from annotation:  @QeexMessage(id = 101, code = 400, message = " complete e ricmplete")
        int _id = 102;
        Integer code = 400;
        String message = " complete e ricmplete";
        String language = null;
        return new QeexWebException(qeexConfig.get_project(classProjectName),
                _id,
                qeexConfig.get_code(_id, code),
                qeexConfig.get_message(_id, message, languageInterceptor.getLanguage()),
                qeexConfig.get_language(_id, language));
    }
}
