package com.example.test;

import com.example.test.Model.TestDB;
import com.example.test.Service.TestService;
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

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class TestApplicationTests {

    @Autowired
    TestService testService;

    private final String Base_Path = "http://localhost:8080/test";
    private RestTemplate restTemplate;

    @BeforeEach
    public void setUp() {

        testService.deleteAll();

        testService.add(new TestDB("Seokjoong"));
        testService.add(new TestDB("Yeji"));
        testService.add(new TestDB("Yeseul"));

        restTemplate = new RestTemplate();
    }

    @Test
    public void testGetWIthName() {
        TestDB testDB = restTemplate.getForObject(Base_Path + "/get/Seokjoong", TestDB.class);
        assert testDB != null;
        Assert.assertEquals("Seokjoong", testDB.getName());
    }

    @Test
    public void update() {

    }

    @Test
    public void create() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        TestDB testDB = new TestDB("Junghwa");

        HttpEntity<TestDB> request = new HttpEntity<>(testDB, headers);
        restTemplate.postForObject(Base_Path + "/create", request, TestDB.class);
        List<TestDB> list = testService.findAll();
        Assert.assertEquals(list.size(), 4);
    }

    @Test
    public void delete() {

    }

}
