
package com.zoya.belt.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zoya.belt.models.Rating;
import com.zoya.belt.models.TvShow;
import com.zoya.belt.models.User;
import com.zoya.belt.services.RatingService;
import com.zoya.belt.services.TvShowService;

@Controller
public class TvShows {
	private TvShowService tservice;
	private RatingService rservice;
	
	public TvShows(TvShowService tservice,RatingService rservice) {
		this.tservice=tservice;
		this.rservice=rservice;
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		model.addAttribute("allShows",tservice.findAll());
		return "dashboard";
	}
	
	@RequestMapping("/addShow")
	public String addShow(Model model) {
		model.addAttribute("tvshow",new TvShow());
		return "tvShow";
	}
	
	@PostMapping("/create")
		public String create(@Valid @ModelAttribute("tvshow") TvShow tvShow, BindingResult result,RedirectAttributes flash) {
		if(result.hasErrors()) {
			return"tvShow";
		}
		
		ArrayList<TvShow> tvShows = tservice.findAll();
		for(TvShow show: tvShows) {
			if(show.getTitle().equals(tvShow.getTitle())) {
				flash.addFlashAttribute("error","This show already exists!");
				return "redirect:/addShow";
			}
		}
		
		tservice.create(tvShow);
	
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/show/{id}")
	public String findOne(Model model, @PathVariable("id") Long id) {
		model.addAttribute("show",tservice.findOne(id));
		model.addAttribute("my_rating",new Rating());
		return "display";
	}
	
	@PostMapping("/rate/{id}")
	public String rating(@ModelAttribute("my_rating") Rating rating, BindingResult result, Model model, @PathVariable("id") Long id,HttpSession session,RedirectAttributes flash){
		User user = (User) session.getAttribute("user");
		
		if(user == null) {
			model.addAttribute("show", tservice.findOne(id));
			flash.addFlashAttribute("errors", "Please login to rate this show!");
			return "redirect:/show/"+id;
		}
		
		if(result.hasErrors()) {
			model.addAttribute("show", tservice.findOne(id));
			
			return "display";
		}
		
		TvShow t = tservice.findOne(id);
		List<Rating> ratings = t.getRating();
		for(Rating rate: ratings) {
			
			if(rate.getUser().getId() == user.getId()) {
				flash.addFlashAttribute("errors", "You have already reviewed this show!");
				
				return "redirect:/show/"+id;
			}
		}
		
		Rating rating1=new Rating(rating.getRating(),rating.getTvshow(),user);
		System.out.println(user.getId());
		rservice.create(rating1);

		TvShow show=rating.getTvshow();
		if(rating.getTvshow().getAvgRating()==null) {
			show.setAvgRating(rating.getRating());
			
		}
		else {
			
			show.setAvgRating(rating.getRating()+show.getAvgRating());
		}
		
		tservice.update(show);
		return "redirect:/show/"+id;
	}
	
	@RequestMapping("/edit/{id}")
	public String edit(Model model, @PathVariable("id") Long id) {
		model.addAttribute("tvshow", tservice.findOne(id));
		return "edit";
	}
	
	@PostMapping("/update/{id}")
	public String updateEvnt(@Valid @ModelAttribute("tvshow") TvShow tvShow, BindingResult result, @PathVariable("id") Long id) {
		if(result.hasErrors()) {
			return "edit";
		} 
		
		tservice.update(tvShow);
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/delete/{id}")
    public String destroy(@PathVariable("id") Long id) {
		TvShow tvShow =tservice.findOne(id);
        tservice.destroy(tvShow);
        return "redirect:/dashboard";
    }
	
}
