package com.zhazha.zha.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhazha.zha.model.Employee;
import com.zhazha.zha.repository.EmployeeRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public Flux<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Mono<Employee> findByEmployeeId(int number) {
        return employeeRepository.findById(number);
    }

    public Flux<Employee> findByStatus(String status) {
        return employeeRepository.findByEmploymentStatus(status);
    }

    public Flux<Employee> findByRole(String role) {
        return employeeRepository.findByEmployeeRole(role);
    }

    public Mono<Employee> save(Employee employee) {
        return employeeRepository.save(employee);
    }

    /*public Mono<Customer> update(int number, Customer customer) {
        return customerRepository.findById(number).map(Optional::of).defaultIfEmpty(Optional.empty())
                .flatMap(optionalCustomer -> {
                    if (optionalCustomer.isPresent()) {
                        customer.setCustomerNumber(number);
                        return customerRepository.save(customer);
                    }
                    return Mono.empty();
                });
    }*/

    public Mono<Void> deleteByID(int number) {
        return employeeRepository.deleteById(number);
    }
}
