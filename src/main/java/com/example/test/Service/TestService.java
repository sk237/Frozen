package com.example.test.Service;

import com.example.test.Model.TestDB;

import java.util.List;


public interface TestService {
    TestDB getByName(String name);
    void add(TestDB testDB);
    void deleteAll();
    void update(TestDB testDb);
    void delete(String name);
    void create(String name);
    List<TestDB> findAll();
}
