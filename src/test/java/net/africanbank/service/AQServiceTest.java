package net.africanbank.service;

import net.africanbank.AbstractTest;
import net.africanbank.domain.ApplicationQueue;
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
public class AQServiceTest extends AbstractTest{

    @Autowired
    private ApplicationQueueService service;

    @Before
    public void setUp(){
        //service.evictCache();
    }

    @After
    public  void tearDown(){

    }

    @Test
    public void testFindAll(){
        Collection<ApplicationQueue> result = service.findAll();
        Assert.assertNotNull("failure - The result should not be Null", result);
        Assert.assertEquals("failure - The result should not be Null", true, result.size()>0);
    }

    @Test
    public void testFindUsingParams(){
        ApplicationQueue result = service.findApplicationByParam("LOAN", "AFF", "AFF05");
        Assert.assertNotNull("failure - The result should be Null", result);

        result = service.findApplicationByParam("PM_LOAN", "PM_NORMAL", "");
        Assert.assertNull("failure - The result should not be Null", result);

    }
    @Test
    public void testUpdate(){
        ApplicationQueue data = new ApplicationQueue(1, "RuleLoanAFF05", "LOAN", "AFF", "AFF05", "ID|CUSTDECLBOBO");

        ApplicationQueue result = service.update(data);
        Assert.assertNotNull("failure - The result should not be Null", result);
        Assert.assertEquals("failure - The expected result is ID|CUSTDECL", result.getResult(), "ID|CUSTDECLBOBO");
    }
    @Test
    public void testSave(){
        ApplicationQueue result = service.save("Rule ABCD", "LOAN", "AFF", "AFF05", "ID|CUSTDECL|ABCD");
        Assert.assertNotNull("failure - The result should not be Null", result);

        Assert.assertEquals("failure - The expected result is ID|CUSTDECL|ABCD", result.getResult(), "ID|CUSTDECL|ABCD");

    }


}
