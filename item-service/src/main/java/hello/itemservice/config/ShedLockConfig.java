package hello.itemservice.config;

import net.javacrumbs.shedlock.provider.jdbc.JdbcLockProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ShedLockConfig {

    @Bean
    public JdbcLockProvider jdbcLockProvider(DataSource dataSource) {
        return new JdbcLockProvider(dataSource);
    }
}
