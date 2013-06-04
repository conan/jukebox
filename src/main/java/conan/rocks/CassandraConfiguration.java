package conan.rocks;

import com.yammer.dropwizard.config.Configuration;
import org.codehaus.jackson.annotate.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CassandraConfiguration extends Configuration {

    @JsonProperty
    @NotEmpty
    private List<String> contactPoints;

    @JsonProperty
    @NotEmpty
    private String keyspaceName;

    public List<String> getContactPoints() {
        return contactPoints;
    }

    public String getKeyspaceName() {
        return keyspaceName;
    }
}
