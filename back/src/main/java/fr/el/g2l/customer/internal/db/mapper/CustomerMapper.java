package fr.el.g2l.customer.internal.db.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import fr.el.g2l.common.dto.Customer;
import fr.el.g2l.customer.internal.db.models.CustomerDb;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", source = "id")
    Customer toDto(CustomerDb customerDb);

    @Mapping(target = "id", source = "id")
    CustomerDb toEntity(Customer customer);

    List<Customer> toDtoList(List<CustomerDb> customerDbList);
    
    List<CustomerDb> toEntityList(List<Customer> customerList);
}
