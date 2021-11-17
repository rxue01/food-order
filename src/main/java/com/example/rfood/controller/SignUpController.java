package com.example.rfood.controller;

import com.example.rfood.entity.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.example.rfood.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;


@Controller // from spring MVC

public class SignUpController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/signUp", method = RequestMethod.POST) //  define REST API, requestbody used jackson
    @ResponseStatus(value = HttpStatus.CREATED) // show if succeed


    public void signUp(@RequestBody Customer customer){
        customerService.signUp(customer);
        System.out.println(customer.getEmail());
    }
}
