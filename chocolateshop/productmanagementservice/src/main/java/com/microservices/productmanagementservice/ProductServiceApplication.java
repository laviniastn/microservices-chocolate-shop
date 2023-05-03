package com.microservices.productmanagementservice;
import com.microservices.productmanagementservice.dto.ProductDTO;
import com.microservices.productmanagementservice.model.Category;
import com.microservices.productmanagementservice.services.CategoryService;
import com.microservices.productmanagementservice.services.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ProductServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner run(ProductService productService, CategoryService categoryService) {
        return args -> {
            Category categoryBoxes = categoryService.create(new Category(Category.CATEGORY_BOXES));

            List<Category> categories1 = new ArrayList<>();
            categories1.add(categoryBoxes);

            productService.create(new ProductDTO("Praline", "ciocolata diverse sortimente", "cacao, unt, zahar",
                    20.5F, 500F), categories1);

        };
    }
}

