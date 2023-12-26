package ge.mais.api.controllers;

import ge.mais.api.dto.AddCustomer;
import ge.mais.api.entities.Customer;
import ge.mais.api.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class CustomerController {
    final CustomerService customerService;
    @Autowired

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @RequestMapping(value="/all", method = RequestMethod.GET, produces = {"application/json"})
    public List<Customer> getAll(){
        return customerService.getAll();
    }

    @RequestMapping(value="/add", method = RequestMethod.POST, produces = {"application/json"})
    public Customer add(@RequestBody AddCustomer addCustomer){
        return customerService.addCustomer(addCustomer);
    }
}
