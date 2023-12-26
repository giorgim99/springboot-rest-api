package ge.mais.api.controllers;

import ge.mais.api.entities.Address;
import ge.mais.api.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class AddressController {
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }
@RequestMapping(value="/all", method = RequestMethod.GET, produces = {"application/json"})
    public List<Address> getAll(){
        return addressService.getAll();
    }


}
