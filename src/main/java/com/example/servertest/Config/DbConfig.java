package com.example.servertest.Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {
        "com.example.servertest.Repositories"
})
@Configuration
@ComponentScan
public class DbConfig {
}
