package lk.ijse.posbackend.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "lk.ijse.posbackend")
@EnableJpaRepositories(basePackages = "lk.ijse.posbackend")
@EnableTransactionManagement
public class WebAppRootConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public DataSource dataSource() {
        var dbms = new DriverManagerDataSource();
        dbms.setDriverClassName("com.mysql.jdbc.Driver");
        dbms.setUrl("jdbc:mysql://localhost:3306/pos_javaee?createDatabaseIfNotExist=true");
        dbms.setUsername("root");
        dbms.setPassword("1234");
        return dbms;
    }
}
