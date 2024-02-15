package com.ecommerce.entity;

import jakarta.persistence.*;

@Entity
public class Favourites {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_fc", nullable = false)
    private UserData userData;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;


    public Favourites () {}

    public Favourites(UserData userData, Product product) {
        this.userData = userData;
        this.product = product;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
