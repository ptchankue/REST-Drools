package net.africanbank.service;

import net.africanbank.domain.ProductVariant;
import net.africanbank.repository.ProductVariantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by patricktchankue on 5/13/16.
 */
@Service
@Transactional
public class ProductVariantServiceImpl implements ProductVariantService {

    @Autowired
    private ProductVariantRepository productVariantRepository;


    public List<ProductVariant> findAll() {
        return productVariantRepository.findAll();
    }

    public ProductVariant findByProductAndVariant(String product, String variant){
        return productVariantRepository.findByProductAndVariant(product, variant);
    }
    public ProductVariant findByRuleName(String ruleName){
        return productVariantRepository.findByRuleName(ruleName);
    }

//    public ProductVariant save(String product, String variant, String result){
//        return productVariantRepository.save(new ProductVariant(product, variant, result));
//    }
    public ProductVariant save(String ruleName, String product, String variant, String result){
        return productVariantRepository.save(new ProductVariant(ruleName, product, variant, result));
    }
    public ProductVariant update(ProductVariant data){

        ProductVariant update =  productVariantRepository.findOne(data.getId());

        if(update != null){
            update.setRuleName(data.getRuleName());
            update.setProduct(data.getProduct());
            update.setVariant(data.getVariant());
            update.setResult(data.getResult());

            return productVariantRepository.save(update);

        } else {
            return null;
        }

    }

    public void delete(ProductVariant data){

    }

}
