package com.jimmy9.shop.catalog.service;

import com.jimmy9.shop.catalog.dao.ProductDao;
import com.jimmy9.shop.catalog.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductDao productDao;

    @Autowired
    public ProductService(@Qualifier("fakeDaoProduct") ProductDao productDao){
        this.productDao = productDao;
    }

    public int addNewProduct(UUID productId, Product product){
        UUID productUid = productId == null ? UUID.randomUUID() : productId;
        product.setId(productUid);
        return productDao.addNewProduct(productUid, product);
    }

    public List<Product> getAllProducts(){
        return productDao.selectAllProducts();
    }

    public Product getProductById(UUID productId){
        return productDao.selectById(productId);
    }

    public int deleteProductById(UUID productId){
        return productDao.deleteProductById(productId);
    }
}
