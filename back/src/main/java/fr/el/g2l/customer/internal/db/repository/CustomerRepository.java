package fr.el.g2l.customer.internal.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.el.g2l.customer.internal.db.models.CustomerDb;

public interface CustomerRepository extends JpaRepository<CustomerDb, Long> {


}
