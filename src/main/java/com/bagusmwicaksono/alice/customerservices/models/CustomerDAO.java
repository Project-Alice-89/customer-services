package com.bagusmwicaksono.alice.customerservices.models;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;

public interface CustomerDAO extends MongoRepository<Customer,String> {
    Collection<Customer> findByEmail(String email);
}
