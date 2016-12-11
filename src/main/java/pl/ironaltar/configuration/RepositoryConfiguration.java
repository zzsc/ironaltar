package pl.ironaltar.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SuppressWarnings("deprecation")
@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"pl.ironaltar.domain"})
@EnableJpaRepositories(basePackages = {"pl.ironaltar.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
