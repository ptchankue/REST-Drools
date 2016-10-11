package net.africanbank.service;

import net.africanbank.domain.ProductVariant;

import java.util.List;

/**
 * Created by patricktchankue on 5/13/16.
 */
public interface ProductVariantService {

    List<ProductVariant> findAll();

    ProductVariant findByProductAndVariant(String product, String variant);
    ProductVariant save(String ruleName, String product, String variant, String result);
    ProductVariant update(ProductVariant data);
    void delete(ProductVariant data);

}
