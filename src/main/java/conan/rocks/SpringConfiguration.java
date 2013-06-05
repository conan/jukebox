package conan.rocks;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import conan.rocks.dao.ClusterFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {

    @Bean
    public CassandraConfiguration cassandraConfiguration() {
        return new CassandraConfiguration();
    }

    @Bean
    public JukeboxService jukeboxService() {
        return new JukeboxService();
    }

    @Bean
    public ClusterFactoryBean clusterFactoryBean() {
        return new ClusterFactoryBean();
    }

    @Bean
    public Cluster cluster() {
        return clusterFactoryBean().getObject();
    }

    @Bean
    public Session session() {
        return cluster().connect(cassandraConfiguration().getKeyspaceName());
    }
}
