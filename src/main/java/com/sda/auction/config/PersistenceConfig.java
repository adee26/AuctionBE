package com.sda.auction.config;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class PersistenceConfig {
    @Bean
    public DataSource getDataSource(){
        return DataSourceBuilder.create()
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .url("jdbc:mysql://localhost:3306/auction")
                .username("test")
                .password("test")
                .build();
    }

    @Bean
    public SpringLiquibase getSpringLiquibase(){
        SpringLiquibase springLiquibase = new SpringLiquibase();
        springLiquibase.setChangeLog("classpath:db/changelog/liquibase-changelog.xml");
        springLiquibase.setDataSource(this.getDataSource());
        return springLiquibase;
    }
}
