package com.revature.ProjectTwo.beans.controllers;

import com.revature.ProjectTwo.beans.services.CustomerService;
import com.revature.ProjectTwo.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "/{customerId}")
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody Customer getCustomerById(@PathVariable Integer customerId){
        Optional<Customer> optionalCustomer = customerService.getCustomerById(customerId);
        try{
            optionalCustomer.isPresent();
        }catch(Exception e){
            System.out.println(e);
        }
        return optionalCustomer.get();
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @PostMapping
    public void  registerCustomer(@RequestBody Customer customer){
        customerService.createCustomer(customer);
    }

    @DeleteMapping(path = "{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer customerId){
        customerService.deleteCustomer(customerId);
    }

}
