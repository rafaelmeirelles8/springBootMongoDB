package com.example.springmongodb.repository.address;

import com.example.springmongodb.entity.Address.Address;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository<Address, String> {


}
