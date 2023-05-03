package com.microservices.productmanagementservice.controllers;

import com.microservices.productmanagementservice.model.Product;
import com.microservices.productmanagementservice.services.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;


//@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/products")
public class ProductController {

    private static final Logger logger = Logger.getLogger(ProductController.class);

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {

        logger.setLevel(Level.DEBUG);
        this.productService = productService;
    }

    @ApiOperation(value = "Get list of users", response = Iterable.class, tags = "getAllUsers")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "Not authorized!"),
            @ApiResponse(code = 403, message = "Forbidden!"),
            @ApiResponse(code = 404, message = "Not found!")})
    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts() {

        logger.debug("Get all products");
        return ResponseEntity.ok().body(productService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Integer id) {
        logger.debug("Get product by id");
        return ResponseEntity.ok().body(productService.findAll().get(id-1));
    }



    @PostMapping(value = "/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) throws NoSuchAlgorithmException {
        logger.debug("Create product");
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.insert(product));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Product>  updateProduct(@RequestBody Product product) {
        logger.debug("Update product");
        return ResponseEntity.ok().body(productService.update(product));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") Integer id) {
        logger.debug("Delete product");
        productService.delete(id);
        return ResponseEntity.ok().body(null);

    }

}

