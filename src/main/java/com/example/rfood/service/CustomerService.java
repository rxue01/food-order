package com.example.rfood.service;
import com.example.rfood.dao.CustomerDao;
import com.example.rfood.entity.Cart;
import com.example.rfood.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired

    private CustomerDao customerDao;

    public void signUp(Customer customer) {
        Cart cart = new Cart();
        customer.setCart(cart);
        customer.setEnabled(true);
        customerDao.signUp(customer);
    }// create a customer and save to DB with Dao

    public Customer getCustomer(String email) {
        return customerDao.getCustomer(email);
    }
}



