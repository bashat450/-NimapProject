package com.project.Entity;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity //to create table in database
public class Categories {
	
	@Id // primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY) //auto increment id
	private int c_id;// Category Id
	private String c_name;// Category Name
	@OneToMany(mappedBy ="ctg",cascade = CascadeType.ALL)
	
	private List<Products> products; //list of product
	
  // create getter setter to fetch or put the data	
	public List<Products> getProducts() {
		return products;
	}
	public void setProducts(List<Products> products) {
		this.products = products;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	@Override
	public String toString() {
		return "Categories [c_id=" + c_id + ", c_name=" + c_name + "]";
	}
	
	

}
