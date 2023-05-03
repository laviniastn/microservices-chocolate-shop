package com.microservices.productmanagementservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "product")
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String productName;

    private String productDescription;

    private String productIngredients;

    private Float productPrice;

    private Float productWeight;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories = new ArrayList<>();

    public Product(String productName, String productDescription, String productIngredients,
                   Float productPrice, Float productWeight, List<Category> categories){
        this.productName=productName;
        this.productDescription=productDescription;
        this.productIngredients=productIngredients;
        this.productPrice=productPrice;
        this.productWeight=productWeight;
        this.categories=categories;

    }

    public Product(Integer id,String productName, String productDescription, String productIngredients,
                   Float productPrice, Float productWeight, List<Category> categories){
        this.id=id;
        this.productName=productName;
        this.productDescription=productDescription;
        this.productIngredients=productIngredients;
        this.productPrice=productPrice;
        this.productWeight=productWeight;
        this.categories=categories;

    }

}
