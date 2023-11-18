package com.zhazha.zha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.zhazha.zha.model.Customer;
import com.zhazha.zha.service.CustomerService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Customer> getAllCustomers(@RequestParam(required = false) String customerName, String zip) {
        if (customerName != null)
            return customerService.findByCustomerName(customerName);
        else if (zip != null)
            return customerService.findByZip(zip);
        else
            return customerService.findAll();
    }

    @GetMapping("/customer/{number}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Customer> getCustomerByNumber(@PathVariable("number") String number) {
        return customerService.findByCustomerNumber((number));
    }

    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Customer> createCustomer(@RequestBody Customer customer) {
        return customerService.save(new Customer(customer.getCustomerNumber(), customer.getCustomerAddress(),
                customer.getZip(), customer.getCustomerName()));
    }

    @PutMapping("/customers/{number}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Customer> updateCustomer(@PathVariable("number") String number, @RequestBody Customer customer) {
        return customerService.update(number, customer);
    }

    @DeleteMapping("/customers/{number}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteCustomer(@PathVariable("number") String number) {
        return customerService.deleteByCustomerNumber(number);
    }

}
