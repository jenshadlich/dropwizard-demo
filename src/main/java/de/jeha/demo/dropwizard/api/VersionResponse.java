package de.jeha.demo.dropwizard.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author jenshadlich@googlemail.com
 */
public class VersionResponse {

    @JsonProperty
    private final String name;

    @JsonProperty
    private final String version;

    @JsonProperty
    private final String buildTime;

    @JsonProperty
    private final String revision;

    public VersionResponse(String name, String version, String buildTime, String revision) {
        this.name = name;
        this.version = version;
        this.buildTime = buildTime;
        this.revision = revision;
    }

}
