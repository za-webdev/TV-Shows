package com.zoya.belt.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.zoya.belt.models.TvShow;

public interface TvShowRepository extends CrudRepository<TvShow, Long> {
	@Query(value="SELECT * FROM shows ORDER BY avg_rating DESC;", nativeQuery=true)
	List<TvShow> findAll();
	
	

}
