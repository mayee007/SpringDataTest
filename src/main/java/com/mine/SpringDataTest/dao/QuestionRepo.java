package com.mine.SpringDataTest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mine.SpringDataTest.Model.Question;


@RepositoryRestResource(collectionResourceRel="question", path="question")
public interface QuestionRepo extends JpaRepository<Question, Integer> {
}
