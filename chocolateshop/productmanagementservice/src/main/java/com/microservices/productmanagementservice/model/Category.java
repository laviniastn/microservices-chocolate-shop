package com.microservices.productmanagementservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "category")
@Getter
@Setter
@NoArgsConstructor
public class Category {

    public static final String CATEGORY_BOXES = "CATEGORY_BOXES";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String categoryName;

    public Category( String categoryName){
        this.categoryName=categoryName;

    }

}
