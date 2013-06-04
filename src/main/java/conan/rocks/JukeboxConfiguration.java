package conan.rocks;

import com.yammer.dropwizard.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

public class JukeboxConfiguration extends Configuration {

    @Autowired
    private CassandraConfiguration cassandraConfiguration;

    public CassandraConfiguration getCassandraConfiguration() {
        return cassandraConfiguration;
    }
}
