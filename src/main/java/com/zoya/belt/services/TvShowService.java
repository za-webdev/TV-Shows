package com.zoya.belt.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.zoya.belt.models.TvShow;
import com.zoya.belt.repositories.TvShowRepository;

@Service
public class TvShowService {
	
	private TvShowRepository showRepo;
	
	public TvShowService(TvShowRepository showRepo) {
		this.showRepo=showRepo;
	}
	
	public TvShow create(TvShow tvShow) {
		return showRepo.save(tvShow);
	}
	
	public TvShow update(TvShow tvShow) {
		return showRepo.save(tvShow);
	}
	
	public ArrayList<TvShow> findAll() {
		return (ArrayList<TvShow>) showRepo.findAll();
	}
	
	public TvShow findOne(Long id) {
		return showRepo.findOne(id);
	}
	
	public void destroy(TvShow tvShow) {
        showRepo.delete(tvShow);
    }
}
