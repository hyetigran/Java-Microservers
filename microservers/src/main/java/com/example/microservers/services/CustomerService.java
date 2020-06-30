package com.example.microservers.services;

import com.example.microservers.Web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {

    CustomerDto getCustomerById(UUID customerid);

    CustomerDto saveNewCustomer(CustomerDto customerDto);

    void updateCustomer(UUID customerid, CustomerDto customerDto);

    void deleteById(UUID customerid);
}
