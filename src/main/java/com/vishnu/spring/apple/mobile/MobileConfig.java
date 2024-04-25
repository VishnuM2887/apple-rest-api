package com.vishnu.spring.apple.mobile;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MobileConfig {

    @Bean
    CommandLineRunner commandLineRunner(MobileRepository repository) {
        return args -> {
            Mobile mobile1 = new Mobile(
                "iPhone",
                "15",
                "ProMax",
                256,
                "Titanium Black",
                156000D
            );
            Mobile mobile2 = new Mobile(
                "iPhone",
                "15",
                null,
                128,
                "Space Gray",
                70000D
            );
            // repository.saveAll(List.of(mobile1, mobile2));
        };
    }

}