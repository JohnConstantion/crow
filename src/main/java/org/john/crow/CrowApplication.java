package org.john.crow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author johnconstantine
 */
@SpringBootApplication
@EnableJpaRepositories
public class CrowApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrowApplication.class, args);
    }

}
