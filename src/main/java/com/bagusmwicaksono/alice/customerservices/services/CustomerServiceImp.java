package com.bagusmwicaksono.alice.customerservices.services;

import com.bagusmwicaksono.alice.customerservices.models.Customer;
import com.bagusmwicaksono.alice.customerservices.models.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImp implements CustomerService {
    private final CustomerDAO customerDAO;

    @Autowired
    public CustomerServiceImp(CustomerDAO customerDAO){
        this.customerDAO=customerDAO;
    }

    @Override
    public Boolean isCustomerDuplicated(Customer customer) {
        return !customerDAO.findByEmail(customer.getEmail()).isEmpty();
    }

    @Override
    public Customer performCustomerRegistration(Customer customer) {
        return customerDAO.save(customer);
    }
}
