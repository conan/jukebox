package conan.rocks;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import conan.rocks.api.TrackAcceptor;
import conan.rocks.api.TrackResource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JukeboxService extends Service<JukeboxConfiguration> {

    public static void main(String[] args) throws Exception {
        new JukeboxService().run(args);
    }

    @Override
    public void initialize(Bootstrap<JukeboxConfiguration> bootstrap) {
        bootstrap.setName("jukebox");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("conan.rocks");
        context.refresh();
    }

    @Override
    public void run(JukeboxConfiguration configuration, Environment environment) throws Exception {
        environment.addResource(new TrackResource());
        environment.addResource(new TrackAcceptor());
    }
}
