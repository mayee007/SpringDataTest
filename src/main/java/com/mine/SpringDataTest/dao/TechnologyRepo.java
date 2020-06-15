package com.mine.SpringDataTest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mine.SpringDataTest.Model.Technology;

//@EnableRedisRepositories
@RepositoryRestResource(collectionResourceRel="technology", path="technology")
public interface TechnologyRepo extends JpaRepository<Technology, Integer> {
	 @Query("FROM Technology ORDER BY category DESC")
	 List<Technology> findAllOrderByCategory();
}
