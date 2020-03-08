package com.example.test.Controller;

import com.example.test.Model.TestDB;
import com.example.test.Service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/test")
public class MainController {

    private final TestService testService;

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

    @PostMapping(value = "/create")
    public TestDB create(@RequestBody TestDB testdb) {
        testService.update(testdb);
        return testdb;
    }

}
