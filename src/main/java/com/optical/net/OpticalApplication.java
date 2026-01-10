package com.optical.net;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OpticalApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(OpticalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
