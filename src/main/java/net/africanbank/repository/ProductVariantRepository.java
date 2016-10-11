package net.africanbank.repository;

import net.africanbank.domain.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductVariantRepository extends JpaRepository<ProductVariant,Long> {

    ProductVariant findByProductAndVariant(String product, String variant);
    ProductVariant findByRuleName(String ruleName);

    //ProductVariant find

}