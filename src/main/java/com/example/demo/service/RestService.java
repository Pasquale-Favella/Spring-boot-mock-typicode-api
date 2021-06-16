package com.example.demo.service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.example.demo.constants.UserApi;

import com.example.demo.dto.UserDto;
import com.example.demo.model.Address;
import com.example.demo.model.Company;
import com.example.demo.model.Geo;
import com.example.demo.model.User;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestService {

    @Autowired
	private RestTemplate restTemplate;


	@Autowired
    private EntityManager em;


    @Transactional
    public void loadAllUsers() {

        System.out.println("Loading data...");
        for (UserDto u: restTemplate.getForObject(UserApi.API_URL, UserDto[].class) )
            mapAndPersistUserFromDto(u);
    
	}

    private void mapAndPersistUserFromDto(UserDto u){

        ModelMapper modelMapper = new ModelMapper();
        Geo geo =modelMapper.map(u.getAddress().getGeo(),Geo.class);

        Address address = modelMapper.map(u.getAddress(),Address.class);
        Company company = modelMapper.map(u.getCompany(),Company.class);

        User user = modelMapper.map(u,User.class);

        geo.setAddress(address);
        address.setGeo(geo);
        address.setUser(user);
        company.setUser(user);
        user.setAddress(address);
        user.setCompany(company);
        em.persist(user);
        
    }
    
}
