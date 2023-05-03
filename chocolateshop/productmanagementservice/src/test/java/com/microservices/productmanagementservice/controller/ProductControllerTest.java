package com.microservices.productmanagementservice.controller;

import com.microservices.productmanagementservice.controllers.ProductController;
import com.microservices.productmanagementservice.model.Category;
import com.microservices.productmanagementservice.model.Product;
import com.microservices.productmanagementservice.services.CategoryService;
import com.microservices.productmanagementservice.services.ProductService;
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
public class ProductControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    ProductController productController;

    @MockBean
    private CategoryService categoryService;

    @MockBean
    private ProductService productService;


    @Test
    public void test_productController_getAllProducts() throws Exception {

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders
                        .get("/products")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();


    }

    @Test
    public void test_productController_getProductById() throws Exception {

        List<Product> productList = new ArrayList<>();
        List<Category> categories = new ArrayList<>();
        categories.add(new Category("CATEGORY_BOXES"));
        Product product = new Product("Praline", "ciocolata diverse sortimente", "cacao, unt, zahar",
                20.5F, 500F, categories);
        productList.add(product);

        given(productService.findAll()).willReturn(productList);

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders
                        .get("/products/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();


    }

    @Test
    public void test_productController_createProduct() throws Exception {

        MvcResult mvcResult = mvc.perform(post("/products/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(Utils.postJsonBodyProduct)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();


    }

    @Test
    public void test_productController_updateProduct() throws Exception {

        MvcResult mvcResult = mvc.perform(put("/products/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(Utils.putJsonBodyProduct)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

    }

    @Test
    public void test_productController_deleteProduct() throws Exception {

        MvcResult mvcResult = mvc.perform(delete("/products/delete/1"))
                .andExpect(status().isOk())
                .andReturn();

    }
}
