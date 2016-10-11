package net.africanbank.controller;

import net.africanbank.AbstractControllerTest;
import net.africanbank.domain.ProductVariant;
import net.africanbank.service.ProductVariantService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Transactional
public class ProductVariantControllerTest extends AbstractControllerTest {

    @Autowired
    private ProductVariantService pv_service;

    @Before
    public void setUp(){
        super.setUp();
    }
    @Test
    public void testGetAll() throws Exception {

        String url = "/product/variant/";

        MvcResult result = mock.perform(MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON))
                .andReturn();

        String content = result.getResponse().getContentAsString();
        int status = result.getResponse().getStatus();

        Assert.assertEquals("failure - expected HTTP status 200", 200, status);
        Assert.assertEquals("failure - expected the body to have a value", true, content.trim().length()>0);


    }

    @Test
    public void testCreate() throws Exception {

        String url = "/product/variant/create";

        ProductVariant obj = new ProductVariant();
        //obj.setId(1000);
        obj.setRuleName("RuleToCreate");
        obj.setProduct("PM_LOAN");
        obj.setVariant("PM_NORMAL");
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
    public void testUpdate() throws Exception {

        String url = "/product/variant/update";
        ProductVariant obj = new ProductVariant();
        obj.setId(1);
        obj.setRuleName("RulePM_LOANPM_LOAN1");
        obj.setProduct("PM_LOAN");
        obj.setVariant("PM_NORMAL");
        obj.setResult("1000");

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
    public void testGetRule() throws Exception {
        String url = "/product/variant?product=PM_LOAN&variant=PM_NORMAL";

        MvcResult result = mock.perform(MockMvcRequestBuilders.get(url).contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String content = result.getResponse().getContentAsString();
        int status = result.getResponse().getStatus();

        Assert.assertEquals("failure - expected HTTP status 200", 200, status);
        //Assert.assertEquals("failure - expected the body to have a value", true, content.trim().length()>0);

    }

    @Test
    public void testFailedGetRule() throws Exception {
        String url = "/product/variant?product=P&variant=PM_NORMAL";

        MvcResult result = mock.perform(MockMvcRequestBuilders.get(url).contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String content = result.getResponse().getContentAsString();
        int status = result.getResponse().getStatus();

        Assert.assertEquals("failure - expected HTTP status 200", 200, status);
        Assert.assertEquals("failure - expected the body to have no value", false, content.trim().length()>0);

    }

}