package com.jimmy9.shop.catalog.dao;

import com.jimmy9.shop.catalog.model.Product;

import java.util.List;
import java.util.UUID;

public interface ProductDao {

    int addNewProduct(UUID productId, Product product);

    Product selectById(UUID productId);

    List<Product> selectAllProducts();

    int deleteProductById(UUID productId);
}
