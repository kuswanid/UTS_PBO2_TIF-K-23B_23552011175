package org.kuswanid.service;

import org.kuswanid.model.Customer;
import org.kuswanid.repository.CustomerRepository;

import java.util.List;
import java.util.UUID;

public class CustomerService {
    private final CustomerRepository repository = new CustomerRepository();

    public boolean addCustomer(String address, String email, String name, String phone) {
        String id = UUID.randomUUID().toString();
        return repository.addCustomer(id, address, email, name, phone);
    }

    public boolean deleteCustomer(String id) {
        return repository.deleteCustomer(id);
    }

    public List<Customer> getAllCustomers() {
        return repository.getAllCustomers();
    }

    public Customer getCustomerDetail(String id) {
        return repository.getCustomerDetail(id);
    }

    public boolean updateCustomer(String id, String address, String email, String name, String phone) {
        return repository.updateCustomer(id, address, email, name, phone);
    }
}
