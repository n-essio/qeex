package org.acme.getting.rs;


import io.quarkus.qeex.api.annotations.QeexExceptionBundle;
import io.quarkus.qeex.api.annotations.QeexMessage;
import io.quarkus.qeex.api.exceptions.QeexWebException;

@QeexExceptionBundle(project = "FLW")
public interface AllExceptions {

    @QeexMessage(message = "prova")
    QeexWebException simpleException();

    @QeexMessage(id = 101, code = 400, message = " complete e ricmplete")
    QeexWebException completeException();

}
