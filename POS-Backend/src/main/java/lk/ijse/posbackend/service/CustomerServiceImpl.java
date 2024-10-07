package lk.ijse.posbackend.service;

import lk.ijse.posbackend.dao.CustomerDAO;
import lk.ijse.posbackend.dto.CustomerDTO;
import lk.ijse.posbackend.entity.CustomerEntity;
import lk.ijse.posbackend.exception.DataPersistFailedException;
import lk.ijse.posbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
