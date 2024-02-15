package com.ecommerce.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table( name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<UserData> userData;


    //Constructor
    public Role() {
    }

    public Role(Integer id, String name) {
        this.id = id;
        this.name = name;
    }


    //Getter & Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
