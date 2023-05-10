package uir.ac.projet2;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Projet2Application {

	public static void main(String[] args) {
		SpringApplication.run(Projet2Application.class, args);
	}

	@Bean
	public ModelMapper modelMapper() { // added model mapper
		return new ModelMapper();
	}
}
