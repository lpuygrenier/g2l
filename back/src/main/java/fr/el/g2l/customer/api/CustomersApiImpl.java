package fr.el.g2l.customer.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import fr.el.g2l.customer.generated.api.CustomersApi;
import fr.el.g2l.customer.generated.api.model.Customer;
import fr.el.g2l.customer.internal.service.CustomerService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class CustomersApiImpl implements CustomersApi {

    private final CustomerService customerService;

    @Override
    public ResponseEntity<List<Customer>> getCustomers() {
        return ResponseEntity.ok(customerService.findAll());
    }
        
}
