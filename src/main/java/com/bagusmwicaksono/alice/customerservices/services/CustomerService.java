package com.bagusmwicaksono.alice.customerservices.services;

import com.bagusmwicaksono.alice.customerservices.models.Customer;

public interface CustomerService {
    Boolean isCustomerDuplicated(Customer customer);
    Customer performCustomerRegistration(Customer customer);
}
