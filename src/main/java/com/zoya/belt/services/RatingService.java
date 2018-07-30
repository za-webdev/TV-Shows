package com.zoya.belt.services;

import org.springframework.stereotype.Service;

import com.zoya.belt.models.Rating;
import com.zoya.belt.models.TvShow;
import com.zoya.belt.repositories.RatingRepository;

@Service
public class RatingService {
	 private RatingRepository ratingRepo;
	 
	  public RatingService(RatingRepository ratingRepo) {
		  this.ratingRepo=ratingRepo;
	  }
	  
	  public Rating create(Rating rating) {
		  System.out.println(rating.getRating()+"from repo");
			return ratingRepo.save(rating);
		}
	  
	  public Rating findOne(Long id) {
			return ratingRepo.findOne(id);
		}
	  
}
