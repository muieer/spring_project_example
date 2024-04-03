package io.github.muieer.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DataSourceConfig {

    /*
    * @ConfigurationProperties(prefix = "spring.datasource.xxx.hikari") 会读取匹配的健值对，根据键名称找到对应 bean 的 set 方法，
    * 调用 set 方法将值写入。
    * */
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.xxx.hikari")
    public HikariDataSource dataSource() {
        return new HikariDataSource();
    }
}
