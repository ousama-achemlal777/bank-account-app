package com.example.customerservce;

import com.example.customerservce.entities.Customer;
import com.example.customerservce.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> {
            /* Methode 1:
            Customer customer1 = Customer.builder()
                    .firstName("Oussama")
                    .lastName("achemlal")
                    .email("oussama.achemlal7@gmail.com")
                    .build();   // gràce à l'anotation @Builder nous construisons un object Customer à partir de ses attributs sans utiliser le constructeur sans agruments et les setters ou le constructeur avec les arguments
            customerRepository.save(customer1);
            Customer customer2 = Customer.builder()
                    .firstName("ahmed")
                    .lastName("achemlal")
                    .email("ahmed.achemlal7@gmail.com")
                    .build();
            customerRepository.save(customer2);
            */

            // Methode 2: on peut utilser List of costumers and saveAll()
            List<Customer> customersList = List.of(
                    Customer.builder()
                            .firstName("Oussama")
                            .lastName("Achemlal")
                            .email("oussama.achemlal7@gmail.com")
                            .build() ,
                    Customer.builder()
                            .firstName("Ahmed")
                            .lastName("Achemlal")
                            .email("Ahmed.achemlal@gmail.com")
                            .build(),
                    Customer.builder()
                            .firstName("anas")
                            .lastName("fahmi")
                            .email("anas.fahmi@gmail.com")
                            .build()

            );

            customerRepository.saveAll(customersList);
        };
    }
}
