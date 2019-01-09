package com.gmail.derevets.artem;

import com.gmail.derevets.artem.web.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;


@SpringBootApplication
@ComponentScan("com.gmail.derevets.artem")
@EnableJpaRepositories(basePackages = {
        "com.gmail.derevets.artem.web.repository"
})
@EnableTransactionManagement
@PropertySource(value = {"classpath:application.properties",
        "classpath:application-release.properties"})
public class ResourceServerApplication extends SpringBootServletInitializer {


    public static void main(String[] args) {
        SpringApplication.run(ResourceServerApplication.class, args);
    }


}