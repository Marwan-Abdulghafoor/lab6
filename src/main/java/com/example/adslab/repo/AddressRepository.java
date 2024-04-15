package com.example.adslab.repo;

import com.example.adslab.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    public Address findByZip(String zip);
}
