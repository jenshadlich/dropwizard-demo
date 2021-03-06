package de.jeha.demo.dropwizard;

import de.jeha.demo.dropwizard.config.DemoConfiguration;
import de.jeha.demo.dropwizard.health.DummyHealthCheck;
import de.jeha.demo.dropwizard.resources.HelloResource;
import de.jeha.demo.dropwizard.resources.ThrowExceptionResource;
import de.jeha.demo.dropwizard.resources.VersionResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.glassfish.jersey.server.ServerProperties;

import java.util.Locale;

/**
 * @author jenshadlich@googlemail.com
 */
public class DropwizardDemoService extends Application<DemoConfiguration> {

    private static final String APPLICATION_NAME = "dropwizard-demo-service";

    public static void main(String... args) throws Exception {
        Locale.setDefault(Locale.ENGLISH);
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
        environment.jersey().register(new HelloResource(configuration.getHelloMessage()));
        environment.jersey().register(new VersionResource());
        environment.jersey().register(new ThrowExceptionResource());

        environment.healthChecks().register("dummy", new DummyHealthCheck());

        environment.jersey().disable(ServerProperties.WADL_FEATURE_DISABLE);
    }

}
