package conan.rocks;

import com.netflix.astyanax.AstyanaxContext;
import com.netflix.astyanax.Keyspace;
import com.yammer.dropwizard.lifecycle.Managed;
import org.springframework.beans.factory.annotation.Autowired;

public class KeyspaceManager implements Managed {

    @Autowired
    private AstyanaxContext<Keyspace> astyanaxContext;

    @Override
    public void start() throws Exception {
        astyanaxContext.start();
    }

    @Override
    public void stop() throws Exception {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
