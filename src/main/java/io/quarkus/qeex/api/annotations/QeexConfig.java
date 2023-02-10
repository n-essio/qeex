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
        for (Message msg : messages()) {
            if (msg.id().isPresent() && msg.id().get().equals(id)) {
                if (msg.code().isPresent()) {
                    return msg.code().get();
                }
            }
        }
        return code;
    }

    default String get_message(int id, String message) {

        for (Message msg : messages()) {
            if (msg.id().isPresent() && msg.id().get().equals(id)) {
                if (msg.message().isPresent()) {
                    return msg.message().get();
                }
            }
        }
        return message;
    }

    default String get_project(String project) {
        return project().orElse(project);
    }
}
