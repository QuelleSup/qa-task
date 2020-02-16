package com.task.api.config;

import com.task.selenium.pageobjects.SignUpPage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.util.logging.Logger;

@Configuration
@ComponentScan(basePackages = "com.task.api")
@PropertySource("classpath:api.properties")
public class TestConfig {
    private static final Logger LOG = Logger.getLogger(SignUpPage.class.getName());

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    BasicTestProperties testProperties(
            @Value("${username}") String username,
            @Value("${password}") String password,
            @Value("${test.url}") String basicUrl) {
        return new BasicTestProperties(username, password, basicUrl);
    }
}
