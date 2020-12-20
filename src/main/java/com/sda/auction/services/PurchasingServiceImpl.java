package com.sda.auction.services;

import com.sda.auction.repositories.PurchasingRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PurchasingServiceImpl implements PurchasingService {
    private final PurchasingRepository purchasingRepository;

}
