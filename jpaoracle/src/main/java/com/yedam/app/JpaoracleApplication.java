package com.yedam.app;

import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.yedam.app.accessingdatajpa.Customer;
import com.yedam.app.accessingdatajpa.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class JpaoracleApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaoracleApplication.class, args);
	}
	
	
	 // CommandLineRunner >> main method 실행 시 함께 실행됨. 
	 @Bean
	  public CommandLineRunner demo(CustomerRepository repository) {
	    return (args) -> {

	      // save a few customers
	      repository.save(new Customer("Jack", "Bauer"));
	      repository.save(new Customer("Chloe", "O'Brian"));
	      repository.save(new Customer("Kim", "Bauer"));
	      repository.save(new Customer("David", "Palmer"));
	      repository.save(new Customer("Michelle", "Dessler"));

	      // fetch all customers
	      log.info("Customers found with findAll():");
	      log.info("-------------------------------");
	      repository.findAll().forEach(customer -> {
	        log.info(customer.toString());
	      });
	      log.info("");

	      // fetch an individual customer by ID
	      Optional<Customer> customer = repository.findById(1L);
	      log.info("Customer found with findById(1L):");
	      log.info("--------------------------------");
	      log.info(customer.get().toString());
	      log.info("");

	      // fetch customers by last name
	      log.info("Customer found with findByLastName('Bauer'):");
	      log.info("--------------------------------------------");
	      repository.findByLastName("Bauer").forEach(bauer -> {
	        log.info(bauer.toString());
	      });
	      log.info("");
	    };
	  }
}	
