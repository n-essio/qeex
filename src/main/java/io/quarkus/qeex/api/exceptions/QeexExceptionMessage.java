package io.quarkus.qeex.api.exceptions;

public class QeexExceptionMessage {
    public String projectName;
    public int code;
    public String message;
    public String language;


    public QeexExceptionMessage(String projectName, int code, String message, String language) {
        this.projectName = projectName;
        this.code = code;
        this.message = message;
        this.language = language;
    }

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
