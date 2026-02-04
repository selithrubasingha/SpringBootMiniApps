package com.example.demo.OwnerDemo;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String email;
    private String address;
    private String company;

    @ElementCollection
    private List<String> ownedLand ;

    public Owner() {
    }

    public Owner(String username, String email, String address, String company, List<String> ownedLand) {
        this.username = username;
        this.email = email;
        this.address = address;
        this.company = company;
        this.ownedLand = ownedLand;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public List<String> getOwnedLand() {
        return ownedLand;
    }

    public void setOwnedLand(List<String> ownedLand) {
        this.ownedLand = ownedLand;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return id == owner.id && Objects.equals(username, owner.username) && Objects.equals(email, owner.email) && Objects.equals(address, owner.address) && Objects.equals(company, owner.company) && Objects.equals(ownedLand, owner.ownedLand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, email, address, company, ownedLand);
    }
}
