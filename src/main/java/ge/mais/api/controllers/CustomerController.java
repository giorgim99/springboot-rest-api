package ge.mais.api.controllers;

import ge.mais.api.dto.AddCustomer;
import ge.mais.api.entities.Customer;
import ge.mais.api.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public Boolean delete(@PathVariable Long id){
        return customerService.deleteCustomer(id);
    }
    @RequestMapping(value="/{id}", method = RequestMethod.PUT, produces = {"application/json"})
    public Customer edit(@RequestBody AddCustomer addCustomer, @PathVariable Long id){
        return customerService.addEditCustomer(addCustomer, id);
    }

}
