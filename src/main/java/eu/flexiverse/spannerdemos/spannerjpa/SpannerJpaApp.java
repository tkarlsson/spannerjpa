package eu.flexiverse.spannerdemos.spannerjpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.TimeZone;

@SpringBootApplication
public class SpannerJpaApp {
    private static final Logger LOGGER= LoggerFactory.getLogger(SpannerJpaApp.class);

    public static void main(String[] args) {
        SpringApplication.run(SpannerJpaApp.class, args);
    }

    @PostConstruct
    public void init(){
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));   // It will set UTC timezone
        LOGGER.info("Spring boot application running in UTC timezone: " + new Date());   // It will print UTC timezone
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            LOGGER.info("Starting Spanner JPA Demo");
        };
    }
}
