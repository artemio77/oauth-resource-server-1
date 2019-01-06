package com.gmail.derevets.artem;

import com.gmail.derevets.artem.web.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.Resource;


@SpringBootApplication
@ComponentScan("com.gmail.derevets.artem")
public class ResourceServerApplication extends SpringBootServletInitializer {


    public static void main(String[] args) {
        SpringApplication.run(ResourceServerApplication.class, args);
    }


}