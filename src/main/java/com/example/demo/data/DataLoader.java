package com.example.demo.data;

import com.example.demo.service.RestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner{

    @Autowired
    RestService restService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        restService.loadAllUsers();
        
    }
    
}
