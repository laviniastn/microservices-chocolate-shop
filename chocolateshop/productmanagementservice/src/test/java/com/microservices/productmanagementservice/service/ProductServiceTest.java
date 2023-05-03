package com.microservices.productmanagementservice.service;

import com.microservices.productmanagementservice.dto.ProductDTO;
import com.microservices.productmanagementservice.model.Category;
import com.microservices.productmanagementservice.model.Product;
import com.microservices.productmanagementservice.repositories.ProductRepository;
import com.microservices.productmanagementservice.services.CategoryService;
import com.microservices.productmanagementservice.services.ProductService;

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
public class ProductServiceTest {

    @MockBean
    private ProductRepository productRepository;

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    List<ProductDTO> productsDTO;

    List<Product> products;

    ProductDTO productDTO;

    Product product;

    /**
     * Initialization
     */
    @BeforeEach
    public void SetUp() {
        Category categoryBoxes = categoryService.create(new Category(Category.CATEGORY_BOXES));

        List<Category> categories1 = new ArrayList<>();
        categories1.add(categoryBoxes);

        productService = new ProductService(productRepository);

        productDTO = new ProductDTO("Praline", "ciocolata diverse sortimente", "cacao, unt, zahar",
                20.5F, 500F);

        productsDTO = new ArrayList<>();
        productsDTO.add(productDTO);

        product= new Product(10,"Praline", "ciocolata diverse sortimente", "cacao, unt, zahar",
                20.5F, 500F, categories1);

        products = new ArrayList<>();
        products.add(product);

    }

    @Test
    public void productService_findAll() {
        /**
         *  GIVEN
         */

        given(productRepository.findAll()).willReturn(products);

        /**
         *  WHEN
         */

        List<Product> actualProducts = productService.findAll();

        /**
         * THEN
         */
        assertEquals(products.size(), actualProducts.size());
        assertEquals(products.get(0).getId(), actualProducts.get(0).getId());
        assertEquals(products.get(0).getProductPrice(), actualProducts.get(0).getProductPrice());
        assertEquals(products.get(0).getProductName(), actualProducts.get(0).getProductName());
          }

    @Test
    public void productService_insert() {
        /**
         *  GIVEN
         */

        given(productRepository.save(any())).willReturn(product);
        int expectedId = product.getId();

        /**
         *  WHEN
         */

        int actualId = productService.insert(product).getId();

        /**
         * THEN
         */

        assertEquals(expectedId, actualId);
    }

    @Test
    public void productService_update() {
        /**
         *  GIVEN
         */

        given(productRepository.findById(any())).willReturn(Optional.ofNullable(product));
        given(productRepository.save(any())).willReturn(product);
        int expectedId = products.get(0).getId();

        /**
         *  WHEN
         */

        int actualId = productService.update(product).getId();

        /**
         * THEN
         */

        assertEquals(expectedId, actualId);
    }

    @Test
    public void productService_update_throwResourceNotFoundException() {
        /**
         *  GIVEN
         */

        given(productRepository.findById(any())).willReturn(Optional.ofNullable(null));
        String expectedMessage = "Product not found with product id : '10'";

        /**
         *  WHEN
         */

        Exception exception = assertThrows(ResourceNotFoundException.class, () ->
                productService.update(product));
        String actualMessage = exception.getMessage();
        System.out.println(actualMessage);

        /**
         * THEN
         */

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void productService_delete() {
        /**
         *  GIVEN
         */

        int expectedSize = 0;
        doNothing().when(productRepository);

        /**
         *  WHEN
         */

        productService.delete(product.getId());

        /**
         * THEN
         */

        List<Product> products = productService.findAll();
        assertEquals(expectedSize, products.size());
    }
}
