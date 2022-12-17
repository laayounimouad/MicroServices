package ma.laayouni.inventoryservice;

import ma.laayouni.inventoryservice.Entities.Product;
import ma.laayouni.inventoryservice.repo.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ProductRepository productRepository){
		return args ->{
			productRepository.saveAll(List.of(
					Product.builder().price(1111).name("name1").quantity(11).build(),
					Product.builder().price(2222).name("name2").quantity(22).build(),
					Product.builder().price(3333).name("name3").quantity(33).build(),
					Product.builder().price(4444).name("name4").quantity(44).build()
			));
		};
	}
}
