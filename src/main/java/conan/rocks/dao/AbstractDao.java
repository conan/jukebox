package conan.rocks.dao;

import com.netflix.astyanax.Keyspace;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractDao {

    @Autowired
    private Keyspace keyspace;
}
