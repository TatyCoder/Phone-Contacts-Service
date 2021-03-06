package com.phone.contacts.controller;

import com.phone.contacts.model.Address;
import com.phone.contacts.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/api")    // url -> http://localhost:9092/api
public class AddressController {

    private AddressService addressService;

    @Autowired
    public void setAddressService(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/user/{userId}/contact/{contactId}/address")   // url -> http://localhost:9092/api/user/userId/contact/contactId/address
    public Address getAddress(@PathVariable Long userId, @PathVariable Long contactId) {
        System.out.println("calling getAddress");
        return addressService.getAddress(userId, contactId);
    }

    @PostMapping("/user/{userId}/contact/{contactId}/address")   // url -> http://localhost:9092/api/user/userId/contact/contactId/address
    public Address createAddress(@PathVariable Long userId, @PathVariable Long contactId, @RequestBody Address addressObject) {
        System.out.println("calling createAddress");
        return addressService.createAddress(userId, contactId, addressObject);
    }

    @GetMapping("/user/{userId}/contact/{contactId}/address/{addressId}")   // url -> http://localhost:9092/api/user/userId/contact/contactId/address/addressId
    public Address getAddressById(@PathVariable Long userId, @PathVariable Long contactId, @PathVariable Long addressId) {
        System.out.println("calling getAddressById");
        return addressService.getAddressById(userId, contactId, addressId);
    }

    @PutMapping("/user/{userId}/contact/{contactId}/address/{addressId}")   // url -> http://localhost:9092/api/user/userId/contact/contactId/address/addressId
    public Address updateAddress(@PathVariable Long userId, @PathVariable Long contactId, @PathVariable Long addressId, @RequestBody Address addressObject) {
        System.out.println("calling updateAddress");
        return addressService.updateAddress(userId, contactId, addressId, addressObject);
    }

    @DeleteMapping("/user/{userId}/contact/{contactId}/address/{addressId}")   // url -> http://localhost:9092/api/user/userId/contact/contactId/address/addressId
    public Address deleteAddress(@PathVariable Long userId, @PathVariable Long contactId, @PathVariable Long addressId) {
        System.out.println("calling deleteAddress");
        return addressService.deleteAddress(userId, contactId, addressId);
    }

}
