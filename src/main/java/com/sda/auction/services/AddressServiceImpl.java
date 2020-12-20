package com.sda.auction.services;

import com.sda.auction.repositories.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

}
