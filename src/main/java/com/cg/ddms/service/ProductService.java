package com.cg.ddms.service;

import org.springframework.stereotype.Service;


import com.cg.ddms.entity.Login;
import com.cg.ddms.entity.Product;

import com.cg.ddms.exception.ProductException;


public interface ProductService {
	
	public Login findUser(String username , String password) throws ProductException;
	
	public Product addProduct(Product product) throws ProductException;
	
	public Product  findProductById(int productId) throws ProductException; 
	
	public void deleteProductById(int productId) throws ProductException;
}
