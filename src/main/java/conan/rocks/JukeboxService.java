package conan.rocks;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import conan.rocks.api.TrackAcceptor;
import conan.rocks.api.TrackResource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@org.springframework.stereotype.Service
public class JukeboxService extends Service<JukeboxConfiguration> {

    @Override
    public void initialize(Bootstrap<JukeboxConfiguration> bootstrap) {
        bootstrap.setName("jukebox");
    }

    @Override
    public void run(JukeboxConfiguration configuration, Environment environment) throws Exception {
        environment.addResource(new TrackResource());
        environment.addResource(new TrackAcceptor());
    }
}
