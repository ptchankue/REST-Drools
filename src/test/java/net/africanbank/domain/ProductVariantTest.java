package net.africanbank.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class ProductVariantTest {

	ProductVariant pv;

	@Test
    public void testHello(){
		assertEquals("a", "a");
	}

    @Test
    public void testProductVariant(){
        pv = new ProductVariant();
        pv.setProduct("Product"); pv.setVariant("Variant"); pv.setResult("Result");
        assertEquals(pv.getProduct(), "Product");
        assertEquals(pv.getVariant(), "Variant");
        assertEquals(pv.getResult(), "Result");

        assertNotNull(pv.getId());
    }

    @Test
    public void testProduct(){
        pv = new ProductVariant();
        pv.setProduct("Product"); pv.setVariant("Variant"); pv.setResult("Result");
        assertEquals(pv.getProduct(), "Product");
        assertEquals(pv.getVariant(), "Variant");
        assertEquals(pv.getResult(), "Result");

        assertNotNull(pv.getId());
    }

    @Test
    public void testProduct1(){
        pv = new ProductVariant("Product", "Variant", "Result");

        assertEquals(pv.getProduct(), "Product");
        assertEquals(pv.getVariant(), "Variant");
        assertEquals(pv.getResult(), "Result");

        assertNotNull(pv.getId());
    }



}