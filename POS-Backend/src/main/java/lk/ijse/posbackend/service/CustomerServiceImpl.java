package lk.ijse.posbackend.service;

import jakarta.transaction.Transactional;
import lk.ijse.posbackend.customobj.CustomerResponse;
import lk.ijse.posbackend.dao.CustomerDAO;
import lk.ijse.posbackend.dto.CustomerDTO;
import lk.ijse.posbackend.entity.CustomerEntity;
import lk.ijse.posbackend.exception.CustomerNotFoundException;
import lk.ijse.posbackend.exception.DataPersistFailedException;
import lk.ijse.posbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private Mapping mapping;

    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        CustomerEntity save = customerDAO.save(mapping.convertCustomerDTOToCustomerEntity(customerDTO));
        if (save == null){
            throw new DataPersistFailedException("cannot save customer");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return mapping.convertCustomerEntityListToCustomerDTOList(customerDAO.findAll());
    }

    @Override
    public CustomerResponse getSelectedCustomer(String id) {
        if (customerDAO.existsById(id)) {
            return mapping.convertCustomerEntityToCustomerDTO(customerDAO.getReferenceById(id));
        }else {
            throw new CustomerNotFoundException("Customer not found");
        }
    }

    @Override
    public void updateCustomer(String id, CustomerDTO customerDTO) {
        Optional<CustomerEntity> tmp = customerDAO.findById(id);
        if (!tmp.isPresent()) {
            throw new CustomerNotFoundException("Customer not found");
        }else {
            tmp.get().setName(customerDTO.getName());
            tmp.get().setAddress(customerDTO.getAddress());
            tmp.get().setEmail(customerDTO.getEmail());
            tmp.get().setContact(customerDTO.getContact());
        }
    }

    @Override
    public void deleteCustomer(String id) {
        Optional<CustomerEntity> tmp = customerDAO.findById(id);
        if (!tmp.isPresent()) {
            throw new CustomerNotFoundException("Customer not found");
        }else {
            customerDAO.deleteById(id);
        }
    }
}
