package org.acme.getting.rs;

import io.quarkus.qeex.api.annotations.QeexConfig;
import io.quarkus.qeex.api.exceptions.QeexWebException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class AllExceptionsImpl implements AllExceptions {

    String classProjectName = "FLW";

    @Inject
    QeexConfig qeexConfig;

    @Override
    //     @QeexMessage(message = "prova")
    public QeexWebException simpleException() {
        int _id = 100;
        Integer code = null;
        String message = "prova";
        return new QeexWebException(qeexConfig.get_project(classProjectName),
                _id,
                qeexConfig.get_code(_id, code),
                qeexConfig.get_message(_id, message),
                null);
    }

    @Override
    public QeexWebException completeException() {
        int _id = 101;
        Integer code = 401;
        String message = " complete e ricmplete";
        return new QeexWebException(qeexConfig.get_project(classProjectName),
                _id,
                qeexConfig.get_code(_id, code),
                qeexConfig.get_message(_id, message),
                null);
    }
}
