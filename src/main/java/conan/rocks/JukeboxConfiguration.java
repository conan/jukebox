package conan.rocks;

import com.yammer.dropwizard.config.Configuration;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class JukeboxConfiguration extends Configuration {

    @Autowired
    @Valid
    @NotNull
    @JsonProperty
    private CassandraConfiguration cassandraConfiguration;

    public CassandraConfiguration getCassandraConfiguration() {
        return cassandraConfiguration;
    }
}
