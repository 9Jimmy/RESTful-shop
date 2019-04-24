package com.jimmy9.shop.shoppingCart.dao;

import com.jimmy9.shop.catalog.model.Product;

import java.util.List;
import java.util.UUID;

public interface ShoppingCartDao {

    int insertProduct(UUID productId);

    List<Product> selectAllProductsFromCart();

    int deleteProductFromCartById(UUID productId);
}
