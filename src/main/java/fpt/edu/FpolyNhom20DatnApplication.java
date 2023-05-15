package fpt.edu;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import fpt.edu.config.StorageProperties;
import fpt.edu.service.StorageService;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class FpolyNhom20DatnApplication {

	public static void main(String[] args) {
		SpringApplication.run(FpolyNhom20DatnApplication.class, args);
	}
	

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args ->{
			storageService.init();
		});
	}
}
