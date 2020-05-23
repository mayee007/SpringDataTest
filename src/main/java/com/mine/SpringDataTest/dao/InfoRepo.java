package com.mine.SpringDataTest.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mine.SpringDataTest.Model.Info;

@RepositoryRestResource(collectionResourceRel="info", path="info")
public interface InfoRepo extends JpaRepository<Info, Integer> {
}
