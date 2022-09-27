package eu.flexiverse.spannerdemos.spannerjpa.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"eu.flexiverse.spannerdemos.spannerjpa.repos"})
@EntityScan(basePackages = {"eu.flexiverse.spannerdemos.spannerjpa.entities"})
@Profile({"prodgcp", "testlocal", "testgcp"})
public class SpannerJpaConfig {
    @Autowired
    private Environment env;
}
