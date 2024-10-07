package lk.ijse.posbackend.controller;

import lk.ijse.posbackend.dto.CustomerDTO;
import lk.ijse.posbackend.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customer")
@RequiredArgsConstructor
public class Customer {

    @Autowired
    private final CustomerService customerService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {

    }
}
