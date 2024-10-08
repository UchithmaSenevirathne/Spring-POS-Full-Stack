package lk.ijse.posbackend.controller;

import lk.ijse.posbackend.customobj.CustomerResponse;
import lk.ijse.posbackend.dto.CustomerDTO;
import lk.ijse.posbackend.exception.CustomerNotFoundException;
import lk.ijse.posbackend.exception.DataPersistFailedException;
import lk.ijse.posbackend.service.CustomerService;
import lk.ijse.posbackend.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@RequiredArgsConstructor
public class Customer {

    @Autowired
    private final CustomerService customerService;

    // Add Logger
    private static final Logger logger = LoggerFactory.getLogger(Customer.class);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addCustomer(@RequestBody CustomerDTO customerDTO) {
        if (customerDTO == null){
            logger.warn("Received null CustomerDTO");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            try {
                customerService.saveCustomer(customerDTO);
                logger.info("Customer saved successfully: {}", customerDTO);
                return new ResponseEntity<>(HttpStatus.CREATED);
            }catch (DataPersistFailedException e){
                logger.error("Failed to persist customer data: {}", customerDTO, e);
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }catch (Exception e){
                logger.error("Unexpected error occurred while saving customer: {}", customerDTO, e);
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CustomerDTO> getAllCustomers() {
        logger.info("Fetching all customers");
        return customerService.getAllCustomers();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerResponse getCustomerById(@RequestParam("id") String id) {
        logger.info("Fetching customer with ID: {}", id);
        return customerService.getSelectedCustomer(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateCustomer(@PathVariable("id") String id, @RequestBody CustomerDTO customerDTO) {
        try {
            if (customerDTO == null && (id == null || customerDTO.equals(""))){
                logger.warn("Invalid customer data provided for update: {}", customerDTO);
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            customerService.updateCustomer(id, customerDTO);
            logger.info("Customer updated successfully: {}", customerDTO);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (CustomerNotFoundException e){
            logger.error("Customer not found: ID {}", id, e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            logger.error("Unexpected error occurred while updating customer: {}", customerDTO, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("id") String id) {
        try {
            customerService.deleteCustomer(id);
            logger.info("Customer deleted successfully: ID {}", id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (CustomerNotFoundException e){
            logger.error("Customer not found for deletion: ID {}", id, e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            logger.error("Unexpected error occurred while deleting customer: ID {}", id, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
