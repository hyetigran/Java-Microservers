package com.example.microservers.services;

import com.example.microservers.Web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID customerid) {
        return CustomerDto.builder().id(UUID.randomUUID()).name("Joe Smith").build();
    }

    @Override
    public CustomerDto saveNewCustomer(CustomerDto customerDto) {
        return null;
    }

    @Override
    public void updateCustomer(UUID customerid, CustomerDto customerDto) {

    }

    @Override
    public void deleteById(UUID customerid) {

    }
}
