package io.quarkus.qeex.api.exceptions;

public class QeexExceptionMessage {
    public String projectName;
    public int code;
    public String message;
    public String language;


    @Override
    public String toString() {
        return "ExceptionMessage{" +
                "projectName='" + projectName + '\'' +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
