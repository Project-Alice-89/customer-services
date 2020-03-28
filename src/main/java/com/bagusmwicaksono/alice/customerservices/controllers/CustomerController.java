package com.bagusmwicaksono.alice.customerservices.controllers;

import com.bagusmwicaksono.alice.customerservices.models.Customer;
import com.bagusmwicaksono.alice.customerservices.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService=customerService;
    }

    @PostMapping("/register")
    public ResponseEntity<Customer> performCustomerRegistration(@RequestBody Customer customer){
        if(customerService.isCustomerDuplicated(customer)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(customerService.performCustomerRegistration(customer), HttpStatus.OK);
    }
}
