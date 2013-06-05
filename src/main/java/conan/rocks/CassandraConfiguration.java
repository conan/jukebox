package conan.rocks;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = "classpath:cassandra.properties")
public class CassandraConfiguration {

    @Autowired
    Environment env;

    @Bean
    public Cluster cluster() {
        return new Cluster.Builder().addContactPoints(env.getProperty("contactPoints").split(",")).build();
    }

    @Bean
    public Session session() {
        return cluster().connect(env.getProperty("keyspaceName"));
    }
}
