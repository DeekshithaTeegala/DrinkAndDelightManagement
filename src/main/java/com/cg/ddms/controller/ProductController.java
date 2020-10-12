package com.cg.ddms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ddms.entity.Login;
import com.cg.ddms.entity.Product;
import com.cg.ddms.exception.ProductException;
import com.cg.ddms.service.ProductService;


class Dog{}

@RestController
@CrossOrigin("*")
public class ProductController
{
	    @Autowired
		ProductService productService;
	    
	    Logger logger = LoggerFactory.getLogger(ProductController.class);
	    
	    @GetMapping("/api/greetings")  // localhost:9092/api/greetings
		public String doThings()
		{
			  Dog d=null;
			  logger.error("This is the  error logs Dog "+d); 
			  logger.info("This is the info logs"); 
			  logger.warn("This is the warning logs");
			  logger.trace("This is the trace logs");
			  String s="This is Hello Controller";
//			  ResponseEntity<String> re=new ResponseEntity<String>(s,HttpStatus.OK);
			  
			return s;
		}
		
		@GetMapping("admin/login/{user}/{pass}")
		public ResponseEntity<Login>  findUserLogin(@PathVariable("user") String username, @PathVariable("pass") String password) throws ProductException
		{
		  
			 Login log = productService.findUser(username,password);
			 if(log==null) {
				 throw new ProductException("Login not successful");
			 }
			 ResponseEntity<Login>  re = new ResponseEntity<Login>(log,HttpStatus.OK);
			 return re;
		}
		
		@PostMapping("product")
		public ResponseEntity<Product> addProduct(@RequestBody Product product) throws ProductException
		{
			Product prod=productService.addProduct(product);
			ResponseEntity<Product>  re = new ResponseEntity<Product>(prod,HttpStatus.OK);

			return re;
		}
		
		@GetMapping("product/{id}")
		public ResponseEntity<Product> findProductById(@PathVariable("id") int productId) throws ProductException
		{
			Product product=productService.findProductById(productId);
			ResponseEntity<Product>  re = new ResponseEntity<Product>(product,HttpStatus.OK);
		    return re;
		}
		
		@DeleteMapping("product/{id}")
        public void deleteProductById(@PathVariable("id") int productId) throws ProductException
        {
			productService.deleteProductById(productId);
        }
		
}














