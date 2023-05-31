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

import com.project.DAO.ProductDAO;
import com.project.Entity.Products;

@RequestMapping("/api")
@RestController
public class ProductsController { //controller for handle the all request from the user
	
	@Autowired
	ProductDAO pr; //  for create object to use their feature
	
	@GetMapping("/product/page") // get all the page 
	public List<Products> getAllProducts(@RequestParam(defaultValue = "0")int page,@RequestParam(defaultValue = "I")int size){
		Page<Products> pagePost = pr.findAll(PageRequest.of(page, size));
		List<Products> allPost = pagePost.getContent();
		return allPost;
	} 
	
	@GetMapping("/products") //get all the product
	public List<Products> getProducts(){
		
		return (List<Products>)pr.findAll();
	}
	@PostMapping("/product") //add the product
	public Products addProduct(Products product) {
		
		pr.save(product);		
		return product;	
	}
	@GetMapping("/products/{id}") // get  product by id
	public Products addProduct(@PathVariable int p_id) {
		
		Products product = pr.findById(p_id).orElse(new Products());
		return product;
	}
	@PutMapping("/products/{id}") // update the product by id
	public Products updateProduct(@RequestBody Products product,@PathVariable int p_id) {
		
		pr.save(product);
		return product;
	} 
	@DeleteMapping("/products/{id}") // delete the product by id
	public Products deleteProduct(@PathVariable int p_id) {
		
		Products product = pr.findById(p_id).orElse(new Products());
		pr.delete(product);
		return product;
	}
		
}
