package com.example.test.Controller;

import com.example.test.Model.TestDB;
import com.example.test.Service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/test")
public class MainController {

    @Autowired
    TestService testService;

    @GetMapping(value = "/get/{name}")
    public TestDB get(@PathVariable String name) {

        return testService.getByName(name);
    }

    @PostMapping(value = "/update/{name}")
    public void update(@PathVariable String name) {
        TestDB testDb = testService.getByName(name);
        testDb.setName(name);
        testService.update(testDb);
    }

    @DeleteMapping(value = "delete/{name}")
    public void delete(@PathVariable String name) {
        testService.delete(name);
    }

    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public TestDB create(@RequestBody TestDB testdb) {
        testService.update(testdb);
        return testdb;
    }

}
