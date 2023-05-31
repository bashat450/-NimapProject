package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.DAO.CategoryDAO;
import com.project.Entity.Categories;

@RequestMapping("/api")
@RestController
public class Category_Controller { //Controller to handle the all the request from user side
	
	@Autowired
	CategoryDAO cr; //creating object to use their feature
	
	@GetMapping("/product/page")  //get all 
	public List<Categories> getAllProducts(@RequestParam(defaultValue = "0")int page,@RequestParam(defaultValue = "I")int size){
		Page<Categories> pagePost = cr.findAll(PageRequest.of(page, size));
		List<Categories> allPost = pagePost.getContent();
		return allPost;
	} 
	
	@GetMapping("/categories") //get all the category as well
	public List<Categories> getCategories() {
		return (List<Categories>) cr.findAll();
	}
	@PostMapping("/categories") //add the categories
	public Categories addCategories(@RequestBody Categories ctg)
	{
		cr.save(ctg);
		return ctg;	
	}
	@GetMapping("/categories/{id}") //get only one by id
	public Categories getCategory(@PathVariable int c_id) {

		Categories ctg = cr.findById(c_id).orElse(new Categories());
		return ctg;		
	}
	@PutMapping("/categories/{id}") // update the category by the id
	public Categories updateCategory(@RequestBody Categories ctg ,@PathVariable int c_id) {
		cr.save(ctg);
		return  ctg;	
	}
	@DeleteMapping("/categories/{id}") // delete category by id
	public Categories deleteCategory(@PathVariable int c_id) {
		
		Categories ctg = cr.findById(c_id).orElse(new Categories());
		cr.delete(ctg);
		return ctg;
		
	}
	
}
