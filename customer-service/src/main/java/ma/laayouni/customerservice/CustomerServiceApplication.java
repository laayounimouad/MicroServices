package ma.laayouni.customerservice;


import ma.laayouni.customerservice.entities.Customer;
import ma.laayouni.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository){
		return args -> {
			customerRepository.saveAll(List.of(
					Customer.builder().name("name1").email("email1").build(),
					Customer.builder().name("name1").email("email1").build(),
					Customer.builder().name("name1").email("email1").build()
			));
			customerRepository.findAll().forEach(System.out::println);
		};
	}
}
