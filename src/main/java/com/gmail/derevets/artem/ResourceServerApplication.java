package com.gmail.derevets.artem;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@SpringBootApplication
@EnableTransactionManagement
@PropertySource(value = {"classpath:application.properties",
        "classpath:application-release.properties"})
public class ResourceServerApplication extends SpringBootServletInitializer {


    public static void main(String[] args) {
        SpringApplication.run(ResourceServerApplication.class, args);
    }


}