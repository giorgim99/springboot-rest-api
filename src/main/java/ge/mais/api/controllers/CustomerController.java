package ge.mais.api.controllers;

import ge.mais.api.dto.AddCustomer;
import ge.mais.api.dto.RequestData;
import ge.mais.api.dto.SearchCustomer;
import ge.mais.api.entities.Customer;
import ge.mais.api.services.CustomerService;
import ge.mais.api.util.GeneralUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/customer")
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
    public Customer add(@RequestBody AddCustomer addCustomer) throws Exception {
        GeneralUtil.checkRequiredProperties(addCustomer,  Arrays.asList("firstName", "lastName", "address"));

        return customerService.addCustomer(addCustomer);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public Boolean delete(@PathVariable Long id){
        return customerService.deleteCustomer(id);
    }


    @RequestMapping(value="/{id}", method = RequestMethod.PUT, produces = {"application/json"})
    public Customer edit(@RequestBody AddCustomer addCustomer, @PathVariable Long id) throws Exception {
        GeneralUtil.checkRequiredProperties(addCustomer,  Arrays.asList("firstName", "lastName", "address"));
        return customerService.addEditCustomer(addCustomer, id);
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST, produces = {"application/json"})
    public Page<Customer> search(@RequestBody RequestData<SearchCustomer> rd) throws Exception {
        GeneralUtil.checkRequiredProperties(rd.getData(), Arrays.asList("active", "searchText"));
        return customerService.search(rd.getData(), rd.getPaging());
    }
}
