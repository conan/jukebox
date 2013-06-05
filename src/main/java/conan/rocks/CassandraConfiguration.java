package conan.rocks;

import com.yammer.dropwizard.config.Configuration;
import org.codehaus.jackson.annotate.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import java.util.List;

public class CassandraConfiguration extends Configuration {

    @Valid
    @JsonProperty
    @NotEmpty
    private List<String> contactPoints;

    @Valid
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
