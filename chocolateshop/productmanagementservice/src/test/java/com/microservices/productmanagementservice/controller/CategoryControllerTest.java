package com.microservices.productmanagementservice.controller;

import com.microservices.productmanagementservice.controllers.CategoryController;
import com.microservices.productmanagementservice.services.CategoryService;
import com.microservices.productmanagementservice.services.ProductService;
import com.microservices.productmanagementservice.model.Category;
import com.microservices.productmanagementservice.utils.Utils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class CategoryControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    CategoryController categoryController;

    @MockBean
    private CategoryService categoryService;

    @MockBean
    private ProductService productService;

    @Test
    public void test_categoryController_getAllCategories() throws Exception {

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders
                        .get("/categories")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

    }

    @Test
    public void test_categoryController_getCategoryById() throws Exception {

        List<Category> categories = new ArrayList<>();
        categories.add(new Category("CATEGORY_BOXES"));

        given(categoryService.findAll()).willReturn(categories);

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders
                        .get("/categories/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();


    }

    @Test
    public void test_categoryController_createCategory() throws Exception {

        MvcResult mvcResult = mvc.perform(post("/categories/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(Utils.postJsonBodyCategory)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();


    }

    @Test
    public void test_categoryController_updateCategory() throws Exception {

        MvcResult mvcResult = mvc.perform(put("/categories/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(Utils.putJsonBodyCategory)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

    }

    @Test
    public void test_categoryController_deleteCategory() throws Exception {

        MvcResult mvcResult = mvc.perform(delete("/categories/delete/1"))
                .andExpect(status().isOk())
                .andReturn();

    }
}
