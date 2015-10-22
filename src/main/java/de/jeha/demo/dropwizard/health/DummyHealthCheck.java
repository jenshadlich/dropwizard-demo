package de.jeha.demo.dropwizard.health;

import com.codahale.metrics.health.HealthCheck;

/**
 * @author jenshadlich@googlemail.com
 */
public class DummyHealthCheck extends HealthCheck {

    @Override
    protected Result check() throws Exception {
        return HealthCheck.Result.healthy();
    }

}