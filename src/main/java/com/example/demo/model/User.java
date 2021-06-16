package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	private String username;
	private String email;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,
            mappedBy = "user")
	private Address address;

	private String phone;
	private String website;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,
            mappedBy = "user")
	private Company company;
    

    public User (){}

    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
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
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getWebsite() {
        return website;
    }
    public void setWebsite(String website) {
        this.website = website;
    }
    public Company getCompany() {
        return company;
    }
    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "User [address=" + address + ", company=" + company + ", email=" + email + ", id=" + id + ", phone="
                + phone + ", username=" + username + ", website=" + website + "]";
    }
    
}
