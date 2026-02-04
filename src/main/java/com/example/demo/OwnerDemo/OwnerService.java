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

    public Owner saveOwner(Owner owner) {
        // Better Logic: Check for null AND empty
        if (owner.getOwnedLand() == null || owner.getOwnedLand().isEmpty()) {
            throw new RuntimeException("Owner must own at least one piece of land!");
        }

        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        if (owner.getEmail() == null || !owner.getEmail().matches(emailRegex)) {
            throw new RuntimeException("Invalid email format!");
        }

        return ownerRepository.save(owner);
    }


}
