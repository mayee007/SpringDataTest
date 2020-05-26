package com.mine.SpringDataTest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mine.SpringDataTest.Model.FullName;
import com.mine.SpringDataTest.Model.FullName2;

@RepositoryRestResource(collectionResourceRel="names2", path="names2")
public interface NameRepo2 extends JpaRepository<FullName2, Integer> {
}
