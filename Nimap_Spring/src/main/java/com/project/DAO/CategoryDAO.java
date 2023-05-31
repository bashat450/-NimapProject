package com.project.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Entity.Categories;

public interface CategoryDAO extends JpaRepository<Categories,Integer>{  // entends JPA to use their method

	
	
	
}