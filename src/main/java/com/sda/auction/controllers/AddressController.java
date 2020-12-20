package com.sda.auction.controllers;

import com.sda.auction.services.AddressService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }
}
