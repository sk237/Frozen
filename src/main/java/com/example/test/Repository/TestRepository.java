package com.example.test.Repository;

import com.example.test.Model.TestDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<TestDB, Long> {
    TestDB findByName(String name);

    void deleteByName(String name);
}
