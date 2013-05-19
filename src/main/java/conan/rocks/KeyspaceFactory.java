package conan.rocks;

import com.netflix.astyanax.AstyanaxConfiguration;
import com.netflix.astyanax.AstyanaxContext;
import com.netflix.astyanax.Keyspace;
import com.netflix.astyanax.connectionpool.ConnectionPoolConfiguration;
import com.netflix.astyanax.connectionpool.ConnectionPoolMonitor;
import com.netflix.astyanax.thrift.ThriftFamilyFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class KeyspaceFactory {

    @Autowired
    private static AstyanaxConfiguration astyanaxConfiguration;

    @Autowired
    private static ConnectionPoolConfiguration connectionPoolConfiguration;

    @Autowired
    private static ConnectionPoolMonitor connectionPoolMonitor;

    public static Keyspace createKeyspace(String clusterName, String keyspaceName) {
        AstyanaxContext<Keyspace> context = new AstyanaxContext.Builder()
                .forCluster(clusterName)
                .forKeyspace(keyspaceName)
                .withAstyanaxConfiguration(astyanaxConfiguration)
                .withConnectionPoolConfiguration(connectionPoolConfiguration)
                .withConnectionPoolMonitor(connectionPoolMonitor)
                .buildKeyspace(ThriftFamilyFactory.getInstance());
        context.start();
        return context.getClient();
    }
}
