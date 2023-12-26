package ge.mais.api.services;

import ge.mais.api.dto.AddAddress;
import ge.mais.api.entities.Address;
import ge.mais.api.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    private final AddressRepository addressRepository;
    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAll(){
        return addressRepository.findAll();
    }

    public Address getAddress(AddAddress addAddress){
        Address address = addressRepository.findOneByAddress(addAddress.getAddress());
        if(address != null){
            return address;
        }
        address = new Address();
        address.setAddress(addAddress.getAddress());
        address.setPostalCode(address.getPostalCode());
        return addressRepository.save(address);
    }

}
