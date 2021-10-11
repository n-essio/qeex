package io.quarkus.qeex.api.annotations;

import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithName;

import java.util.*;

@ConfigMapping(prefix = "qeex")
public interface QeexConfig {

    @WithName("project")
    Optional<String> project();

    @WithName("default.id")
    Optional<Integer> default_id();

    @WithName("default.code")
    Optional<Integer> default_code();

    @WithName("messages")
    Set<Message> messages();

    interface Message {
        Optional<String> message();

        Optional<Integer> code();

        Optional<Integer> id();
    }

    default Integer get_code(int id, Integer code) {
        if (code == null) {
            return default_code().get();
        }
        Optional<Integer> mess = messages()
                .stream()
                .filter(msg -> msg.id().equals(id))
                .findFirst()
                .flatMap(message1 -> message1.code());
        return mess.orElse(code);
    }

    default String get_message(int id, String message) {
        Optional<String> mess = messages()
                .stream()
                .filter(msg -> msg.id().equals(id))
                .findFirst()
                .flatMap(message1 -> message1.message());
        return mess.orElse(message);
    }

    default String get_project(String project) {
        return project().orElse(project);
    }
}