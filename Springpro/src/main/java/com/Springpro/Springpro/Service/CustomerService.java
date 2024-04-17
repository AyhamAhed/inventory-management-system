package com.Springpro.Springpro.Service;

import com.Springpro.Springpro.Model.entity.CustomerModel;
import com.Springpro.Springpro.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerModel> getAllCustomers() {
        return customerRepository.findAll();
    }

    public CustomerModel getCustomerById(Integer id) {
        Optional<CustomerModel> optionalCustomer = customerRepository.findById(id);
        return optionalCustomer.orElse(null);
    }

    public CustomerModel createCustomer(CustomerModel customer) {
        return customerRepository.save(customer);
    }

    public CustomerModel updateCustomer(Integer id, CustomerModel customer) {
        customer.setId(id);
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }

    public CustomerModel partiallyUpdateCustomer(Integer id, CustomerModel updatedCustomer) {
        Optional<CustomerModel> optionalExistingCustomer = customerRepository.findById(id);

        if (optionalExistingCustomer.isPresent()) {
            CustomerModel existingCustomer = optionalExistingCustomer.get();

            if (updatedCustomer.getName() != null) {
                existingCustomer.setName(updatedCustomer.getName());
            }
            if (updatedCustomer.getEmail() != null) {
                existingCustomer.setEmail(updatedCustomer.getEmail());
            }
            if (updatedCustomer.getAddress() != null) {
                existingCustomer.setAddress(updatedCustomer.getAddress());
            }
            if (updatedCustomer.getPhoneNumber() != null) {
                existingCustomer.setPhoneNumber(updatedCustomer.getPhoneNumber());
            }

            return customerRepository.save(existingCustomer);
        } else {
            return null;
        }
    }
}
