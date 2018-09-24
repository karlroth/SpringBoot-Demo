package com.yash.aws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories({"com.yash.aws"})
public class Ec2DemoApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(Ec2DemoApplication.class, args);
	}
}
