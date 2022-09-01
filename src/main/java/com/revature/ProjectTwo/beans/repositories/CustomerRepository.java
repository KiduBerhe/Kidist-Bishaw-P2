package com.revature.ProjectTwo.beans.repositories;


import com.revature.ProjectTwo.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    //@Query("SELECT c FROM Customer c WHERE c.email = ?1")
    //Optional<Customer> findByEmail(String email);
}

