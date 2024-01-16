package ge.mais.api.services;

import ge.mais.api.dto.AddCustomer;
import ge.mais.api.dto.Paging;
import ge.mais.api.dto.SearchCustomer;
import ge.mais.api.entities.Address;
import ge.mais.api.entities.Customer;
import ge.mais.api.repositories.CustomerRepository;
import ge.mais.api.util.GeneralUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    private AddressService addressService;
    @Autowired
    public CustomerService(CustomerRepository customerRepository, AddressService addressService){
        this.customerRepository = customerRepository;
        this.addressService = addressService;
    }


    public List<Customer> getAll(){
        return customerRepository.findAll();
    }
    public Customer getById(Long id){
        return customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer Not Found"));
    }

    @Transactional
    public Customer addCustomer(AddCustomer addCustomer) throws Exception {
        Customer customer = new Customer();
        GeneralUtil.getCopyOf(addCustomer, customer);
        customer.setCreateDate(new Date());
        Address address = addressService.getAddress(addCustomer.getAddress());
        customer.setAddress(address);
        return customerRepository.save(customer);
    }
    @Transactional
    public Customer addEditCustomer(AddCustomer addCustomer, Long id){
        Customer customer = new Customer();
        if(id !=null){
            customer = getById(id);
        }
        customer.setFirstName(addCustomer.getFirstName());
        customer.setLastName(addCustomer.getLastName());
        if(id==null){
            customer.setCreateDate(new Date());
        }
        Address address = addressService.getAddress(addCustomer.getAddress());
        customer.setAddress(address);
        return customerRepository.save(customer);
    }
    @Transactional
    public boolean deleteCustomer(Long id){
        Customer customer = getById(id);
        customerRepository.delete(customer);
        return true;
    }
    public Page<Customer> search(SearchCustomer searchCustomer, Paging paging){
        String searchText = searchCustomer.getSearchText() != null ? "%" + searchCustomer.getSearchText() + "%" : "";
//        Pageable pageable = PageRequest.of(paging.getPage() - 1, paging.getSize(), Sort.by("id").ascending());
//        return customerRepository.search(searchCustomer.getActive(), searchText, pageable);
        Pageable pageable = PageRequest.of(paging.getPage() - 1, paging.getSize(), Sort.by("id").ascending());
        return customerRepository.search(searchCustomer.getActive(), searchText, pageable);

    }
}

