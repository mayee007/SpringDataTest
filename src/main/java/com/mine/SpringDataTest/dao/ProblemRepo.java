package com.mine.SpringDataTest.dao;

import org.springframework.beans.factory.parsing.Problem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="problem", path="problem")
public interface ProblemRepo extends JpaRepository<Problem, Integer> {
}
