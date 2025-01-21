package fr.el.g2l.customer.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import fr.el.g2l.customer.generated.api.CustomersApiDelegate;
import fr.el.g2l.customer.generated.api.model.Customer;
import fr.el.g2l.customer.internal.service.CustomerService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class CustomersApiDelegateImpl implements CustomersApiDelegate {

    private final CustomerService customerService;

    @Override
    public ResponseEntity<List<Customer>> getCustomers() {
        // List<Customer> customers = new ArrayList<>();
        
        // customers.add(new Customer().id(1).name("John Doe").email("john.doe@example.com"));
        // customers.add(new Customer().id(2).name("Jane Smith").email("jane.smith@example.com"));
        // customers.add(new Customer().id(3).name("Bob Johnson").email("bob.johnson@example.com"));
        // customers.add(new Customer().id(4).name("Alice Brown").email("alice.brown@example.com"));
        // customers.add(new Customer().id(5).name("Charlie Davis").email("charlie.davis@example.com"));
        
        // return ResponseEntity.ok(customers);
        return ResponseEntity.ok(customerService.findAll());
    }
        
}
