package com.example.demo.OwnerDemo;


import org.springframework.stereotype.Service;
import java.util.List;

@Service // 1. The Annotation !
public class OwnerService {

    // 2. The Dependancy
    private final OwnerRepository ownerRepository;

    // 3. The linking (connecting)
    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }


}
