package com.yedam.app.accessingdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	List<Customer> findByFirstName(String name);

	List<Customer> findByLastName(String name);
}
