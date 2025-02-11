package fr.el.g2l.customer.internal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.el.g2l.common.dto.Customer;
import fr.el.g2l.customer.internal.db.mapper.CustomerMapper;
import fr.el.g2l.customer.internal.db.models.CustomerDb;
import fr.el.g2l.customer.internal.db.repository.CustomerRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public List<Customer> findAll() {
        List<CustomerDb> customersDb = customerRepository.findAll();
        return customerMapper.toDtoList(customersDb);
    }
}
