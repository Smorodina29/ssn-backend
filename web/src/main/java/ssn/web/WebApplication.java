package ssn.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@Slf4j
public class WebApplication {

    public static void main(String[] args) {
        log.info("Start application.");
        SpringApplication.run(WebApplication.class, args);
        log.info("Application started.");
    }

}
