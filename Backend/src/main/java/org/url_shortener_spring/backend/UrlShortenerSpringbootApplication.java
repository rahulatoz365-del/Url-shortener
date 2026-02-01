package org.url_shortener_spring.backend;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAsync
@SpringBootApplication
public class UrlShortenerSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(UrlShortenerSpringbootApplication.class, args);
    }
}
