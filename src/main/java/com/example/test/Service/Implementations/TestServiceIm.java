package com.example.test.Service.Implementations;

import com.example.test.Model.TestDB;
import com.example.test.Repository.TestRepository;
import com.example.test.Service.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestServiceIm implements TestService {

    private final TestRepository testRepository;

    @Override
    public TestDB getByName(String name) {
        return testRepository.findByName(name);
    }

    @Override
    public void add(TestDB testDB) {
        testRepository.save(testDB);
    }

    @Override
    public void deleteAll() {
        testRepository.deleteAll();
    }

    @Override
    public void update(TestDB testDb) {
        log.info("this is update");
        testRepository.save(testDb);
    }

    @Override
    public void delete(String name) {
        testRepository.deleteByName(name);
    }

    @Override
    public void create(String name) {
        testRepository.save(new TestDB(name));
    }

    @Override
    public List<TestDB> findAll() {
        return testRepository.findAll();
    }
}
