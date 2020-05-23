package com.mine.SpringDataTest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mine.SpringDataTest.Model.Problem;

@RepositoryRestResource(collectionResourceRel="problem", path="problem")
public interface ProblemRepo extends JpaRepository<Problem, Integer> {
}
