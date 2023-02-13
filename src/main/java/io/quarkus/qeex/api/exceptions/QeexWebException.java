package io.quarkus.qeex.api.exceptions;

public class QeexWebException extends Exception {
    public String projectName;
    public int code;
    public int httpCode;
    public String message;        // (4)
    public String language;        // (4)

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


    public String toJson() {
        return "{\"projectName\":\"" + this.projectName + "\"," +
                "\"code\":" + this.code + ", " +
                "\"message\":\"" + this.message + "\", " +
                "\"language\":\"" + this.language + "\"" +
                "}";
    }

    public QeexExceptionMessage msg(String language) {
        return new QeexExceptionMessage(this.projectName, this.code, this.message, this.language);
    }

    public static QeexWebException build(String projectName,
                                         int code,
                                         int httpCode,
                                         String message,
                                         String language) {

        return new QeexWebException(projectName, code, httpCode, message, language);

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
