package org.acme.quex.exception;

import io.quarkus.qeex.api.annotations.QeexConfig;
import io.quarkus.qeex.api.exceptions.QeexWebException;
import io.quarkus.qeex.api.interceptors.LanguageInterceptor;

import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
@Generated(value = "dev.queryable.QuexGenerator", date = "2023-05-04T12:08:56.235-0700", comments = "don't touch please")
public class ExceptionBundleImpl implements ExceptionBundle {

    private static final String xxx = null;

    // copied from application properties: qeex.project=FLW
    String classProjectName = "FLW";

    @Inject
    QeexConfig qeexConfig;

    @Inject
    LanguageInterceptor languageInterceptor;

    @Override
    public QeexWebException simpleException() {
        // from annotation  @QeexMessage(message = "prova")
        //this id IS AUTOMATICALLY GENERATED by method position inside interface
        int _id = 101;
        Integer code = null;
        String message = "prova";
        String language = null;
        return QeexWebException.builder(qeexConfig.get_project(classProjectName))
                .code(_id)
                .code(qeexConfig.get_code(_id, code))
                .message(qeexConfig.get_message(_id, message, languageInterceptor.getLanguage()))
                .language(qeexConfig.get_language(_id, languageInterceptor.getLanguage()));
    }

    @Override
    public QeexWebException completeException() {
        // from annotation: @QeexMessage(id = 101, code = 400, message = " complete e ricmplete")
        //this id IS AUTOMATICALLY GENERATED by method position inside interface
        int _id = 102;
        Integer code = 400;
        String message = " complete e ricmplete";
        String language = null;
        return QeexWebException.builder(qeexConfig.get_project(classProjectName))
                .code(_id)
                .code(qeexConfig.get_code(_id, code))
                .message(qeexConfig.get_message(_id, message, languageInterceptor.getLanguage()))
                .language(qeexConfig.get_language(_id, languageInterceptor.getLanguage()));
    }

    @Override
    public QeexWebException notOverrideException() {
        //from annotation: @QeexMessage(id = 103, code = 500, message = "non sovrascitto")
        //this id IS AUTOMATICALLY GENERATED by method position inside interface
        int _id = 103;
        Integer code = 500;
        String message = "non sovrascitto";
        String language = null;
        return QeexWebException.builder(qeexConfig.get_project(classProjectName))
                .code(_id)
                .code(qeexConfig.get_code(_id, code))
                .message(qeexConfig.get_message(_id, message, languageInterceptor.getLanguage()))
                .language(qeexConfig.get_language(_id, languageInterceptor.getLanguage()));
    }

    @Override
    public QeexWebException withArguments(String one, String two) {
        //from annotation: @QeexMessage(id = 104, code = 500, message = "one: %s - two: %s")
        //this id IS AUTOMATICALLY GENERATED by method position inside interface
        int _id = 104;
        Integer code = 500;
        String message = String.format("one: %s - two: %s", one, two);
        String language = null;
        return QeexWebException.builder(qeexConfig.get_project(classProjectName))
                .code(_id)
                .code(qeexConfig.get_code(_id, code))
                .message(qeexConfig.get_message(_id, message, languageInterceptor.getLanguage()))
                .language(qeexConfig.get_language(_id, languageInterceptor.getLanguage()));
    }

}
