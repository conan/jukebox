package conan.rocks;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import conan.rocks.dao.ClusterFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SpringConfiguration {

    @Autowired
    private CassandraConfiguration cassandraConfiguration;

    @Bean
    @Scope(value = SCOPE_PROTOTYPE)
    public ClusterFactoryBean clusterFactoryBean() {
        ClusterFactoryBean clusterFactory = new ClusterFactoryBean();
        clusterFactory.setContactPoints(cassandraConfiguration.getContactPoints());
        return clusterFactory;
    }

    @Bean
    @Scope(value = SCOPE_PROTOTYPE)
    public Cluster cluster() {
        return clusterFactoryBean().getObject();
    }

    @Bean
    @Scope(value = SCOPE_PROTOTYPE)
    public Session session() {
        return cluster().connect(cassandraConfiguration.getKeyspaceName());
    }
}
