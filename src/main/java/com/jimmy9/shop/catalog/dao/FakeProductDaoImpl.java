package com.jimmy9.shop.catalog.dao;

import com.jimmy9.shop.catalog.model.Product;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("fakeDaoProduct")
public class FakeProductDaoImpl implements ProductDao{

    private final Map<UUID, Product> database;

    public FakeProductDaoImpl(){
        database = new HashMap<>();
        UUID productId = UUID.randomUUID();
        database.put(productId, new Product(productId, "First product", 1000));
    }

    @Override
    public int addNewProduct(UUID productId, Product product) {
        database.put(productId, product);
        return 1;
    }

    @Override
    public Product selectById(UUID productId) {
        return database.get(productId);
    }

    @Override
    public List<Product> selectAllProducts() {
        return new ArrayList<>(database.values());
    }

    @Override
    public int deleteProductById(UUID productId) {
        database.remove(productId);
        return 1;
    }
}
