package de.jeha.demo.dropwizard.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

/**
 * @author jenshadlich@googlemail.com
 */
public class DemoConfiguration extends Configuration {

    @JsonProperty
    private String helloMessage;

    public String getHelloMessage() {
        return helloMessage;
    }
    
}
