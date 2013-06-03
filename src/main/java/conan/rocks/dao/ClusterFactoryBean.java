package conan.rocks.dao;

import com.datastax.driver.core.Cluster;
import org.springframework.beans.factory.FactoryBean;

import java.util.List;

public class ClusterFactoryBean implements FactoryBean<Cluster> {

    private List<String> contactPoints;

    @Override
    public Cluster getObject() throws Exception {
        return new Cluster.Builder().addContactPoints(contactPoints.toArray(new String[0])).build();
    }

    @Override
    public Class<? extends Cluster> getObjectType() {
        return Cluster.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public void setContactPoints(List<String> contactPoints) {
        this.contactPoints = contactPoints;
    }
}
