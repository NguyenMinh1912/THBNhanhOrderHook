package com.thbrabbitserver.thbrabbitmqserver.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppInfo {

    @GetMapping
    public String appHello(){
        return "Hello From thb with love!!!";
    }

}
