package io.quarkus.qeex.api.exceptions;

public class QeexWebException extends Exception {
    public String projectName;
    public int code;
    public int httpCode;
    public String message;        // (4)
    public String language;        // (4)

    public QeexWebException() {
    }

    public QeexWebException(String projectName,
                            int code,
                            int httpCode,
                            String message,
                            String language) {
        super();
        this.projectName = projectName;
        this.code = code;
        this.httpCode = httpCode;
        this.message = message;
        this.language = language;
    }

    public static QeexWebException builder(String projectName) {
        var quex = new QeexWebException();
        quex.projectName = projectName;
        return quex;
    }

    public QeexWebException code(int code) {
        this.code = code;
        return this;
    }

    public QeexWebException httpCode(int httpCode) {
        this.httpCode = httpCode;
        return this;
    }

    public QeexWebException message(String message) {
        this.message = message;
        return this;
    }

    public QeexWebException language(String language) {
        this.language = language;
        return this;
    }


    public String toJson() {
        return "{\"projectName\":\"" + this.projectName + "\"," +
                "\"code\":" + this.code + ", " +
                "\"message\":\"" + this.message + "\", " +
                "\"language\":\"" + this.language + "\"" +
                "}";
    }

    @Override
    public String toString() {
        return "QuarkusWebException{" +
                "projectName='" + projectName + '\'' +
                ", code=" + code +
                ", httpCode=" + httpCode +
                ", message='" + message + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
