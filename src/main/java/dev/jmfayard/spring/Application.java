package dev.jmfayard.spring;

import dev.jmfayard.spring.core.EntityMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	EntityMapper mapper() {
		return Mappers.getMapper(EntityMapper.class);
	}
}
