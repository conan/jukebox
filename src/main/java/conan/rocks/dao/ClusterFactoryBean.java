package conan.rocks.dao;

import com.datastax.driver.core.Cluster;
import conan.rocks.CassandraConfiguration;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

public class ClusterFactoryBean implements FactoryBean<Cluster> {

    @Autowired
    private CassandraConfiguration cassandraConfiguration;

    @Override
    public Cluster getObject() {
        return new Cluster.Builder().addContactPoints(cassandraConfiguration.getContactPoints().toArray(new String[0])).build();
    }

    @Override
    public Class<? extends Cluster> getObjectType() {
        return Cluster.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
