package com.ibm.isl.healthcare.product.controller;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.isl.healthcare.product.vo.Product;


@RestController
public class ProductController {

	Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@GetMapping(value = "/product", produces = {"application/JSON"})
    public List<Product> searchProduct(Product product) {
        return null;
    }
	
    @GetMapping(value = "/product/{productId}", produces = {"application/JSON"})
    public Product getProductDetail(@PathVariable(value = "productId") long productId) {
    	logger.debug("INSIDE getProductDetail");
    	logger.debug("productId:"+productId);
        return new Product();
    }

    @PostMapping(value = "/product")
    public void createProduct(@RequestBody Product product){
    	logger.debug("inside createProduct" );
    	
    	ObjectMapper mapper = new ObjectMapper();
    	try {
			logger.debug("product:"+mapper.writerWithDefaultPrettyPrinter().writeValueAsString(product));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    }

    @PutMapping(value = "/product", consumes = {"application/JSON"})
    public void updateProduct(@PathVariable(value = "productId") long productId, @RequestBody Product product) {
    	logger.debug("inside updateProduct" );
    	
    	ObjectMapper mapper = new ObjectMapper();
    	try {
			logger.debug("product:"+mapper.writerWithDefaultPrettyPrinter().writeValueAsString(product));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    }
    
    @DeleteMapping(value = "/product/{productId}")
    public void retireProduct(@PathVariable(value = "productId") long productId) {
        
    }
}