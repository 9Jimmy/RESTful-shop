package com.jimmy9.shop.shoppingCart.service;

import com.jimmy9.shop.catalog.model.Product;
import com.jimmy9.shop.shoppingCart.dao.ShoppingCartDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ShoppingCartService {

    private final ShoppingCartDao shoppingCartDao;

    @Autowired
    public ShoppingCartService(@Qualifier("fakeDaoShoppingCart") ShoppingCartDao shoppingCartDao){
        this.shoppingCartDao = shoppingCartDao;
    }

    public int insertProduct(UUID productId){
        return shoppingCartDao.insertProduct(productId);
    }

    public List<Product> getAllProductsFromShoppingCart(){
        return shoppingCartDao.selectAllProductsFromCart();
    }

    public int deleteProductFromShoppingCartById(UUID productId){
        return shoppingCartDao.deleteProductFromCartById(productId);
    }
}
