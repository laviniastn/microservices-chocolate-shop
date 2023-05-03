package com.microservices.productmanagementservice.dto;

public record ProductDTO(String productName, String productDescription, String productIngredients,
        Float productPrice, Float productWeight) {
}
