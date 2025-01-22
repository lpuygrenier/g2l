package fr.el.g2l.customer.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.el.g2l.customer.generated.api.CustomersApi;
import fr.el.g2l.customer.generated.api.model.Customer;
import fr.el.g2l.customer.internal.service.CustomerService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class CustomersApiImpl implements CustomersApi {

    private final CustomerService customerService;

    @Override
    public ResponseEntity<List<Customer>> getCustomers() {
        return ResponseEntity.ok(customerService.findAll());
    }
        
}
