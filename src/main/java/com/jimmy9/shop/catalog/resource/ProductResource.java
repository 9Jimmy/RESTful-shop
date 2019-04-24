package com.jimmy9.shop.catalog.resource;

import com.jimmy9.shop.catalog.model.Product;
import com.jimmy9.shop.catalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("9jimmy/shop/catalog")
public class ProductResource {

    private final ProductService productService;

    @Autowired
    public ProductResource(ProductService productService){
        this.productService = productService;
    }

    /**
     * @return all products from database
     * */
    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    /**
     * Adds new product to database
     ***/
    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public void addNewProduct(@RequestBody Product product){
        productService.addNewProduct(UUID.randomUUID(), product);
    }

    /**
     * @return product with specified id
     * */
    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "{productId}"
    )
    public Product getProductById(@PathVariable("productId") UUID productId){
        return productService.getProductById(productId);
    }

    /**
     * Removes product with specified id
     * */
    @RequestMapping(
            method = RequestMethod.DELETE,
            path = "{productId}"
    )
    public void deleteProductById(@PathVariable("productId") UUID productId){
        productService.deleteProductById(productId);
    }
}
