package com.example.microservers.Web.controller;

import com.example.microservers.Web.model.CustomerDto;
import com.example.microservers.services.CustomerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping({"/{customerid}"})
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerid")UUID customerid){
        return new ResponseEntity<>(customerService.getCustomerById(customerid), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody CustomerDto customerDto){
        CustomerDto saveDto = customerService.saveNewCustomer(customerDto);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/customers/"+ saveDto.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{customerid}"})
    public ResponseEntity handleUpdate(@PathVariable("customerid") UUID customerid, @RequestBody CustomerDto customerDto){
        customerService.updateCustomer(customerid, customerDto);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{customerid}"})
    public void deleteCustomer(@PathVariable("customerid") UUID customerid){
        customerService.deleteById(customerid);
    }
}
