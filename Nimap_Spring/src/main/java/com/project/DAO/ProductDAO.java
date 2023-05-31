package com.project.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Entity.Products;


public interface ProductDAO extends JpaRepository<Products,Integer>{// entends JPA to use their method

}
