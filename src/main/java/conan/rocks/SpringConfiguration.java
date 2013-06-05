package conan.rocks;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(CassandraConfiguration.class)
public class SpringConfiguration {

}
