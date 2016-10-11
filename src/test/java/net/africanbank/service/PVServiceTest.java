package net.africanbank.service;

import net.africanbank.AbstractTest;
import net.africanbank.domain.ProductVariant;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by patricktchankue on 5/24/16.
 */

@Transactional
public class PVServiceTest extends AbstractTest{

    @Autowired
    private ProductVariantService service;

    @Before
    public void setUp(){
        //pv_service.evictCache();
    }

    @After
    public  void tearDown(){

    }

    @Test
    public void testFindAll(){
        Collection<ProductVariant> result = service.findAll();
        Assert.assertNotNull("failure - The result should not be Null", result);
        Assert.assertEquals("failure - The result should not be Null", true, result.size()>0);
    }

    @Test
    public void testFindUsingParams(){
        ProductVariant result = service.findByProductAndVariant("", "");
        Assert.assertNull("failure - The result should be Null", result);
        //_list = service.findAll();
        for(int i=0; i< service.findAll().size(); i++){
            System.out.println(service.findAll().get(i));
        }

        result = service.findByProductAndVariant("PM_LOAN", "PM_NORMAL");
        System.out.println(">>>" + result);
        Assert.assertNotNull("failure - The result should not be Null", result);

    }
    @Test
    public void testUpdate(){
        ProductVariant data = service.save("Rule to Update", "PM_LOAN", "PM_NORMAL", "1000");
        data.setResult("1000000");
        ProductVariant result = service.update(data);
        Assert.assertNotNull("failure - The result should not be Null", result);
        Assert.assertEquals("failure - The expected result is 1000000", result.getResult(), "1000000");
    }
    @Test
    public void testSave(){
        ProductVariant result = service.save("Rule to Save", "PM_LOAN_1000", "PM_NORMAL_1000", "1000");
        Assert.assertNotNull("failure - The result should not be Null", result);
    }


}
