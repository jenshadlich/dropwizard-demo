package de.jeha.demo.dropwizard;

import de.jeha.demo.dropwizard.config.DemoConfiguration;
import de.jeha.demo.dropwizard.health.DummyHealthCheck;
import de.jeha.demo.dropwizard.resources.HelloResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.glassfish.jersey.server.ServerProperties;

/**
 * @author jenshadlich@googlemail.com
 */
public class DropwizardDemoService extends Application<DemoConfiguration> {

    private static final String APPLICATION_NAME = "dropwizard-demo-service";

    public static void main(String... args) throws Exception {
        new DropwizardDemoService().run(args);
    }

    @Override
    public String getName() {
        return APPLICATION_NAME;
    }

    @Override
    public void initialize(Bootstrap<DemoConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(DemoConfiguration configuration, Environment environment) {
        environment.jersey().register(new HelloResource());

        environment.healthChecks().register("dummy", new DummyHealthCheck());

        environment.jersey().disable(ServerProperties.WADL_FEATURE_DISABLE);
    }

}
