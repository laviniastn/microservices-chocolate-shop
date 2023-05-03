package com.microservices.productmanagementservice.services;

import com.microservices.productmanagementservice.model.Category;
import com.microservices.productmanagementservice.repositories.CategoryRepository;
import com.microservices.productmanagementservice.validators.CategoryFieldsValidator;
import com.microservices.utils.errorhandler.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements Serializable {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll() {
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }

    public Category getByName(String categoryName) {

        return categoryRepository.findByCategoryName(categoryName);
    }

    public Category create(Category category) {
        CategoryFieldsValidator.validateInsertOrUpdate(category);
        return categoryRepository.save(category);
    }

    public Optional<Category> update(Category category) {

        CategoryFieldsValidator.validateInsertOrUpdate(category);

        Optional<Category> categoryRepo = categoryRepository.findById(Math.toIntExact(category.getId()));
        if (!categoryRepo.isPresent()) {
            throw new ResourceNotFoundException("Category", "category id", category.getId());
        }

        return categoryRepo;
    }

    public void delete(Integer id) {
        this.categoryRepository.deleteById(id);
    }
}

