package com.project.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity //to create table in database
public class Products {

	@Id  // primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY)  //auto increment id
	private int p_id; //product id
	private String p_name; //product  name
	private int p_price; //product price
	private String p_warranty; //product warranty
	private String p_rating; //product rating as well
	@ManyToOne //showing relation between  category and product
	@JoinColumn // join the column
	private Categories ctg;
	
	
	  // create getter setter to fetch or put the data	

	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public int getP_price() {
		return p_price;
	}
	public void setP_price(int p_price) {
		this.p_price = p_price;
	}
	public String getP_warranty() {
		return p_warranty;
	}
	public void setP_warranty(String p_warranty) {
		this.p_warranty = p_warranty;
	}
	public String getP_rating() {
		return p_rating;
	}
	public void setP_rating(String p_rating) {
		this.p_rating = p_rating;
	}
	@Override
	public String toString() {
		return "Products [Sr_no : " + p_id + ", Product_Name=" + p_name + ", Product_Price=" + p_price + ", Product_warranty=" + p_warranty
				+ ", Product_Rating=" + p_rating + "]";
	}
	
	
	
}