package com.example.demo.OwnerDemo;



import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping
    public List<Owner> getAll(){
        return ownerService.getAllOwners();

    }

    @PostMapping
    public Owner saveOwner(@RequestBody Owner owner){
        return ownerService.saveOwner(owner);
    }

}
