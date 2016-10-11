package net.africanbank.controller;

import net.africanbank.AbstractControllerTest;
import net.africanbank.domain.ApplicationQueue;
import net.africanbank.domain.ProductVariant;
import net.africanbank.service.ApplicationQueueService;
import net.africanbank.service.ProductVariantService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class AQControllerTest extends AbstractControllerTest {

    @Autowired
    private ApplicationQueueService service;

    @Before
    public void setUp(){
        super.setUp();
    }
    @Test
    public void testGetAll() throws Exception {

        String url = "/application/queue/";

        MvcResult result = mock.perform(MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON))
                .andReturn();

        String content = result.getResponse().getContentAsString();
        int status = result.getResponse().getStatus();

        Assert.assertEquals("failure - expected HTTP status 200", 200, status);
        Assert.assertEquals("failure - expected the body to have a value", true, content.trim().length()>0);


    }

    @Test
    public void testCreate() throws Exception {

        String url = "/application/queue/create";

        ApplicationQueue obj = new ApplicationQueue();
        //obj.setId(1000);
        obj.setRuleName("RuleToBeAdded");
        obj.setApplicationType("LOAN");
        obj.setQueueName("LOAN");
        obj.setReasonCode("AFF");
        obj.setResult("Result");

        System.out.println("Payload: " + mapToJson(obj));

        MvcResult result = mock.perform(MockMvcRequestBuilders.post(url)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(mapToJson(obj)))
                            .andReturn();

        String content = result.getResponse().getContentAsString();
        System.out.println("Response:" + content);

        int status = result.getResponse().getStatus();

        Assert.assertEquals("failure - expected HTTP status 201", 201, status);
        Assert.assertEquals("failure - expected the body to have a value", true, content.trim().length()>0);


    }

    @Test
    public void testFailedCreate() throws Exception {

        String url = "/application/queue/create";

        ApplicationQueue obj = new ApplicationQueue();
        //obj.setId(1000);
        obj.setRuleName("RuleToBeAdded");
        //obj.setApplicationType("LOAN");
        obj.setQueueName("LOAN");
        obj.setReasonCode("AFF");
        obj.setResult("Result");

        System.out.println("Payload: " + mapToJson(obj));

        MvcResult result = mock.perform(MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapToJson(obj)))
                .andReturn();

        String content = result.getResponse().getContentAsString();
        System.out.println("Response:" + content);

        int status = result.getResponse().getStatus();

        Assert.assertEquals("failure - expected HTTP status 400", 400, status);
        Assert.assertEquals("failure - expected the body to have no value", false, content.trim().length()>0);
    }

    @Test
    public void testUpdate() throws Exception {

        String url = "/application/queue/update";
        ApplicationQueue obj = new ApplicationQueue();
        obj.setId(1);
        obj.setRuleName("RuleLoanAFF05");
        obj.setApplicationType("LOAN");
        obj.setQueueName("AFF");
        obj.setReasonCode("AFF05");
        obj.setResult("ID|CUSTDECL");

        MvcResult result = mock.perform(MockMvcRequestBuilders.put(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapToJson(obj)))
                .andReturn();

        String content = result.getResponse().getContentAsString();
        int status = result.getResponse().getStatus();

        System.out.println("Response:" + content);

        Assert.assertEquals("failure - expected HTTP status 202", 202, status);
        Assert.assertEquals("failure - expected the body to have a value", true, content.trim().length()>0);


    }

    @Test
    public void testFailedUpdate() throws Exception {

        String url = "/application/queue/update";
        ApplicationQueue obj = new ApplicationQueue();
        obj.setId(200);
        obj.setRuleName("RuleLoanAFF05");
        obj.setApplicationType("LOAN");
        obj.setQueueName("AFF");
        obj.setReasonCode("AFF05");
        obj.setResult("ID|CUSTDECL");

        MvcResult result = mock.perform(MockMvcRequestBuilders.put(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapToJson(obj)))
                .andReturn();

        String content = result.getResponse().getContentAsString();
        int status = result.getResponse().getStatus();

        System.out.println("Response:" + content);

        //Assert.assertNotEquals("failure - expected HTTP status 202", 202, status);
        Assert.assertEquals("failure - expected the body to have no value", false, content.trim().length()>0);

    }


    @Test
    public void testDelete() throws Exception {

        String url = "/application/queue/create";

        ApplicationQueue obj = new ApplicationQueue();
        //obj.setId(1000);
        obj.setRuleName("RuleToBeDeleted");
        obj.setApplicationType("LOAN");
        obj.setQueueName("LOAN");
        obj.setReasonCode("AFF");
        obj.setResult("Result");

        MvcResult result = mock.perform(MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapToJson(obj)))
                .andReturn();

        String content = result.getResponse().getContentAsString();

        int status = result.getResponse().getStatus();

        Assert.assertEquals("failure - expected HTTP status 201", 201, status);
        Assert.assertEquals("failure - expected the body to have a value", true, content.trim().length()>0);

        url = "/application/queue/delete";

        result = mock.perform(MockMvcRequestBuilders.delete(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapToJson(obj)))
                .andReturn();

        content = result.getResponse().getContentAsString();

        status = result.getResponse().getStatus();

        Assert.assertEquals("failure - expected HTTP status 204", 204, status);
        Assert.assertEquals("failure - expected the body to have a value", true, content.trim().length()>0);

    }

    @Test
    public void testCheckRule() throws Exception {

        String url = "/application/queue/rule";
        ApplicationQueue obj = new ApplicationQueue();
        obj.setId(1);
        obj.setRuleName("RuleLoanAFF05");
        obj.setApplicationType("LOAN");
        obj.setQueueName("AFF");
        obj.setReasonCode("AFF05");
        obj.setResult("ID|CUSTDECL");

        //url += "?type="+obj.getApplicationType() + "&queue";

        MvcResult result = mock.perform(MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapToJson(obj)))
                .andReturn();

        String content = result.getResponse().getContentAsString();
        int status = result.getResponse().getStatus();

        System.out.println("Response:" + content);

        Assert.assertEquals("failure - expected HTTP status 200", 200, status);
        Assert.assertEquals("failure - expected the body to have a value", true, content.trim().length()>0);


    }


}