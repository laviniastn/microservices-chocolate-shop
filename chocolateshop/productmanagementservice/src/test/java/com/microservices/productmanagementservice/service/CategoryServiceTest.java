package com.microservices.productmanagementservice.service;

import com.microservices.productmanagementservice.model.Category;
import com.microservices.productmanagementservice.repositories.CategoryRepository;
import com.microservices.productmanagementservice.services.CategoryService;
import com.microservices.utils.errorhandler.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;

@SpringBootTest
public class CategoryServiceTest {

    @MockBean
    private CategoryRepository categoryRepository;

    @Autowired
    CategoryService categoryService;


    List<Category> categories;

    Category category;

    /**
     * Initialization
     */
    @BeforeEach
    public void SetUp() {

        Category categoryBoxes = new Category(Category.CATEGORY_BOXES);
        categoryBoxes.setId(10);
        category=categoryBoxes;
        categories = new ArrayList<>();
        categories.add(categoryBoxes);

    }

    @Test
    public void categoryService_findAll() {
        /**
         *  GIVEN
         */

        given(categoryRepository.findAll()).willReturn(categories);

        /**
         *  WHEN
         */

        List<Category> actualCategories = categoryService.findAll();

        /**
         * THEN
         */
        assertEquals(categories.size(), actualCategories.size());
        assertEquals(categories.get(0).getId(), actualCategories.get(0).getId());
    }

    @Test
    public void categoryService_insert() {
        /**
         *  GIVEN
         */

        given(categoryRepository.save(any())).willReturn(category);
        int expectedId = category.getId();

        /**
         *  WHEN
         */

        int actualId = categoryService.create(category).getId();

        /**
         * THEN
         */

        assertEquals(expectedId, actualId);
    }

    @Test
    public void categoryService_update() {
        /**
         *  GIVEN
         */

        given(categoryRepository.findById(any())).willReturn(Optional.ofNullable(category));
        given(categoryRepository.save(any())).willReturn(category);
        int expectedId = category.getId();

        /**
         *  WHEN
         */

        int actualId = categoryService.update(category).get().getId();

        /**
         * THEN
         */

        assertEquals(expectedId, actualId);
    }

    @Test
    public void categoryService_update_throwResourceNotFoundException() {
        /**
         *  GIVEN
         */

        given(categoryRepository.findById(any())).willReturn(Optional.ofNullable(null));
        String expectedMessage = "Category not found with category id : '10'";

        /**
         *  WHEN
         */

        Exception exception = assertThrows(ResourceNotFoundException.class, () ->
                categoryService.update(category));
        String actualMessage = exception.getMessage();


        /**
         * THEN
         */

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void categoryService_delete() {
        /**
         *  GIVEN
         */

        int expectedSize = 1;
        doNothing().when(categoryRepository);


        /**
         *  WHEN
         */

        categoryService.delete(category.getId());

        /**
         * THEN
         */

        assertEquals(expectedSize, categories.size());
    }
}
