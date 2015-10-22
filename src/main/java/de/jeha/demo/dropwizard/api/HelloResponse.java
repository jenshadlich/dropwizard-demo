package de.jeha.demo.dropwizard.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author jenshadlich@googlemail.com
 */
public class HelloResponse {

    @JsonProperty
    private final String message;

    public HelloResponse(String message) {
        this.message = message;
    }

}
