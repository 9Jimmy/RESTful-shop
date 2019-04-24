package com.jimmy9.shop.shoppingCart.dao;

import com.jimmy9.shop.catalog.model.Product;
import com.jimmy9.shop.catalog.service.ProductService;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("fakeDaoShoppingCart")
public class FakeShoppingCartDaoImpl implements ShoppingCartDao{

    private final Map<UUID, Product> database;
    private ProductService productService;

    public FakeShoppingCartDaoImpl(ProductService productService){
        database = new HashMap<>();
        this.productService = productService;
    }


    @Override
    public int insertProduct(UUID productId) {
        Product selectedProduct = productService.getProductById(productId);
        database.put(selectedProduct.getId(), selectedProduct);
        return 1;
    }

    @Override
    public List<Product> selectAllProductsFromCart() {
        return new ArrayList<>(database.values());
    }

    @Override
    public int deleteProductFromCartById(UUID productId) {
        database.remove(productId);
        return 1;
    }
}
