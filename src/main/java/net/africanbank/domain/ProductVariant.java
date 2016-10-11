package net.africanbank.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by patricktchankue on 5/13/16.
 */
@Entity
public class ProductVariant {

    @Id
    @GenericGenerator(name="auto_inc" , strategy="increment")
    @GeneratedValue(generator="auto_inc")
    @Column(name="id")
    long id;

    @NotNull
    @Column(name="ruleName")
    String ruleName;

    @NotNull
    @Column(name="product")
    String product;

    @NotNull
    @Column(name="variant")
    String variant;

    @NotNull
    @Column(name="result")
    String result;

    public ProductVariant(){}
    public ProductVariant(String product, String variant, String result){
        this.product = product;
        this.variant = variant;
        this.result = result;
    }

    public ProductVariant(String ruleName, String product, String variant, String result){
        this.ruleName = ruleName;
        this.product = product;
        this.variant = variant;
        this.result = result;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ProductVariant{" +
                "id=" + id +
                ", ruleName='" + ruleName + '\'' +
                ", product='" + product + '\'' +
                ", variant='" + variant + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
