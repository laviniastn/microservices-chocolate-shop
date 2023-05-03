package com.microservices.productmanagementservice.controllers;

import com.microservices.productmanagementservice.model.Category;
import com.microservices.productmanagementservice.services.CategoryService;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    private static final Logger logger = Logger.getLogger(CategoryController.class);

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        logger.setLevel(Level.DEBUG);
        this.categoryService = categoryService;
    }

    @GetMapping()
    public ResponseEntity<List<Category>> getAllCategories() {

        logger.debug("Get all category");
        return ResponseEntity.ok().body(categoryService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") Integer id) {
        logger.debug("Get category by id");
        return ResponseEntity.ok().body(categoryService.findAll().get(id-1)); // get(index) where index starts from 0
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {

        logger.debug("Create category");
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.create(category));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Optional<Category>> updateCategory(@RequestBody Category category) {
        logger.debug("Update category");
        return ResponseEntity.ok().body(categoryService.update(category));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deleteCategoryById(@PathVariable("id") Integer id) {
        logger.debug("Delete category");
        categoryService.delete(id);
        return ResponseEntity.ok().body(null);
    }

}

