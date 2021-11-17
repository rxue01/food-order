package com.example.rfood.entity;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "customers")


public class Customer implements Serializable {

    private static final long serialVersionUID = 8734140534986494039L;

    @Id
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private boolean enabled;

    @OneToOne(cascade = CascadeType.ALL)// when we are saving a costumer's data, Cascade also save the related cart information
    // CascadeType 可用于各种关系，把有关的class都关联起来同步更新， all 指所有操作
    @JoinColumn(unique = true)
    private Cart cart;

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }



}
