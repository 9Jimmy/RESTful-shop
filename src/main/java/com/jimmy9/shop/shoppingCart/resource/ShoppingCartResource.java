package com.jimmy9.shop.shoppingCart.resource;

import com.jimmy9.shop.catalog.model.Product;
import com.jimmy9.shop.shoppingCart.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("9jimmy/shop/cart")
public class ShoppingCartResource {

    private final ShoppingCartService shoppingCartService;

    @Autowired
    public ShoppingCartResource(ShoppingCartService shoppingCartService){
        this.shoppingCartService = shoppingCartService;
    }

    /**
     * @return all products from shopping cart
     * */
    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Product> getAllProductsFromShoppingCart(){
        return shoppingCartService.getAllProductsFromShoppingCart();
    }

    /**
     * Adds product to shopping cart
     * */
    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            path = "{productId}"
    )
    public void addProductToShoppingCart(@PathVariable("productId") UUID productId){
        shoppingCartService.insertProduct(productId);
    }

    /**
     * Removes product with specified id from shopping cart
     * */
    @RequestMapping(
            method = RequestMethod.DELETE,
            path = "{productId}"
    )
    public void deleteProductFromShoppingCartById(@PathVariable("productId") UUID productId){
        shoppingCartService.deleteProductFromShoppingCartById(productId);
    }
}
