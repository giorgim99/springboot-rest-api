package ge.mais.api.services;

import ge.mais.api.dto.AddCustomer;
import ge.mais.api.entities.Customer;
import ge.mais.api.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAll(){
        return customerRepository.findAll();
    }
    public Customer getById(Long id){
        return customerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Customer Not Found"));
    }

    public Customer addCustomer(AddCustomer addCustomer){
        Customer customer = new Customer();
        customer.setFirstName(addCustomer.getFirstName());
        customer.setLastName(addCustomer.getLastName());
        customer.setCreateDate(new Date());
        return customerRepository.save(customer);
    }
}

