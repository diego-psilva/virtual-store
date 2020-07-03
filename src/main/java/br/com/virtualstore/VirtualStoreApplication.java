package br.com.virtualstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.virtualstore.model.Client;


@SpringBootApplication(
		scanBasePackages = {
		        "br.com.virtualstore",
                "br.com.virtualstore.virtualStoreApplication",
                "br.com.virtualstore.generator",
                "br.com.virtualstore.repository"
        }
)
public class VirtualStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(VirtualStoreApplication.class, args);
	}

	
	@Bean
    public Client getClient(){
	    return new Client(1, "teste");
    }
}

