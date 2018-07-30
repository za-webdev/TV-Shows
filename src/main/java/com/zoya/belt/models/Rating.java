package com.zoya.belt.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="rating")
public class Rating {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private Integer rating;
	
	private Date createdAt;
	private Date updatedAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="tvShow_id")
	private TvShow tvshow;
	
	public Rating() {
		
	}
	

	public Rating(Integer rating ,TvShow tvshow, User user) {
		this.rating=rating;
		this.tvshow=tvshow;
		this.user=user;
		this.createdAt=new Date();
		this.updatedAt=new Date();
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public TvShow getTvshow() {
		return tvshow;
	}

	public void setTvshow(TvShow tvshow) {
		this.tvshow = tvshow;
	}

	@PrePersist
	protected void onCreate(){
		this.updatedAt = new Date();
	    this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate(){
	    this.updatedAt = new Date();
	}
}
