package com.example.echo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EntityScan(basePackages = {"com.example.echo"})
@SpringBootApplication
public class EchoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EchoApplication.class, args);
	}

}
