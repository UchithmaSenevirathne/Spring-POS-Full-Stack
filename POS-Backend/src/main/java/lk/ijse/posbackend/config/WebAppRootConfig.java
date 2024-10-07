package lk.ijse.posbackend.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "lk.ijse.posbackend")
@EnableJpaRepositories(basePackages = "lk.ijse.posbackend")
@EnableTransactionManagement
public class WebAppRootConfig {
}
