package com.mine.SpringDataTest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mine.SpringDataTest.Model.FullName;

@RepositoryRestResource(collectionResourceRel="names", path="names")
public interface NameRepo extends JpaRepository<FullName, Integer> {
}
