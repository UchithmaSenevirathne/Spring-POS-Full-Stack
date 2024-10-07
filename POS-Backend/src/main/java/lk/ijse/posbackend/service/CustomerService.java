package lk.ijse.posbackend.service;

import lk.ijse.posbackend.customobj.CustomerResponse;
import lk.ijse.posbackend.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO customerDTO);

    List<CustomerDTO> getAllCustomers();

    CustomerResponse getSelectedCustomer(String id);

    void updateCustomer(String id, CustomerDTO customerDTO);
}
