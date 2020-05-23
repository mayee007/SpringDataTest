package com.mine.SpringDataTest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mine.SpringDataTest.Model.Technology;

@RepositoryRestResource(collectionResourceRel="technology", path="technology")
public interface TechnologyRepo extends JpaRepository<Technology, Integer> {
}
