package com.example.test;

import com.example.test.Model.TestDB;
import com.example.test.Service.TestService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.google.gson.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class TestApplicationTests {

    @Autowired
    TestService testService;

    final String Base_Path = "http://localhost:8080/test";
    private RestTemplate restTemplate;
    private ObjectMapper objectMapper = new ObjectMapper();



    @BeforeEach
    public void setUp() throws Exception{

        testService.deleteAll();
        testService.add(new TestDB("Seokjoong"));
        testService.add(new TestDB("Yeji"));
        testService.add(new TestDB("Yeseul"));

        restTemplate = new RestTemplate();
    }

    @Test
    public void testGetWIthName() throws Exception{
        String res = restTemplate.getForObject(Base_Path + "/get/Seokjoong", String.class);
        TestDB testDB = objectMapper.readValue(res, TestDB.class);
        Assert.assertEquals("Seokjoong", testDB.getName());
    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void create() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        TestDB testDB = new TestDB("Junghwa");
        String obj = objectMapper.writeValue();
        HttpEntity<String> request = new HttpEntity<>(obj, headers);

        String res = restTemplate.postForObject(Base_Path + "/post", request, String.class);
        TestDB root = objectMapper.readTree(res);
    }

    @Test
    public void delete() throws Exception {

    }

}
