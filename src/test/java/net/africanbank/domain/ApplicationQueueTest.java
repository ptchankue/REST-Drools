package net.africanbank.domain;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by patricktchankue on 5/23/16.
 */
public class ApplicationQueueTest {

    ApplicationQueue aq;

    @Test
    public void testCreateObject(){
        assertNull(aq);

        aq = new ApplicationQueue();
        assertNotNull(aq);

    }

    @Test
    public void testCreateObject1(){

        aq = new ApplicationQueue();
        aq.setRuleName("Rule number 1");
        aq.setApplicationType("AppType");
        aq.setQueueName("QueueName");
        aq.setReasonCode("ReasonCode");
        aq.setResult("Result");

        assertEquals(aq.getRuleName(), "Rule number 1");
        assertEquals(aq.getApplicationType(), "AppType");
        assertEquals(aq.getQueueName(), "QueueName");
        assertEquals(aq.getReasonCode(), "ReasonCode");
        assertEquals(aq.getResult(), "Result");

        assertNotNull(aq.getId());

    }

    @Test
    public void testCreateObject2(){

        aq = new ApplicationQueue("Rule one", "AppType","QueueName","ReasonCode","Result");

        assertEquals(aq.getApplicationType(), "AppType");
        assertEquals(aq.getQueueName(), "QueueName");
        assertEquals(aq.getReasonCode(), "ReasonCode");
        assertEquals(aq.getResult(), "Result");

        assertNotNull(aq.getId());

    }

}
