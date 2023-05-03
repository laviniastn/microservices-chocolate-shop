package com.microservices.productmanagementservice.services;

import com.microservices.productmanagementservice.dto.ProductDTO;
import com.microservices.productmanagementservice.model.Category;
import com.microservices.productmanagementservice.model.Product;
import com.microservices.productmanagementservice.repositories.ProductRepository;

import com.microservices.productmanagementservice.validators.ProductFieldsValidator;
import com.microservices.utils.errorhandler.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    private CategoryService categoryService;

    public Product getByProductName(String productName) {
        return productRepository.findByProductName(productName);
    }

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    public Product insert(Product product) {
        ProductFieldsValidator.validateInsertOrUpdate(product);
        return productRepository.save(product);
    }

    public Product update(Product product) {

        ProductFieldsValidator.validateInsertOrUpdate(product);

        Optional<Product> productRepo = productRepository.findById(Math.toIntExact(product.getId()));
        if (!productRepo.isPresent()) {
            throw new ResourceNotFoundException("Product", "product id", product.getId());
        }

        return productRepository.save(product);
    }

    public void delete(Integer id) {
        this.productRepository.deleteById(id);
    }

    public Product create(ProductDTO request) {
        List<Category> categories = new ArrayList<>();
        try {
            categories.add(categoryService.getByName(Category.CATEGORY_BOXES));
        } catch (Exception ex) {}

        return create(request, categories);
    }

    public Product create(ProductDTO request, List<Category> categories) {
        Product product = new Product(request.productName(),
                request.productDescription(), request.productIngredients(),
                request.productPrice(), request.productWeight(), categories);
        insert(product);
        return product;
    }

}

