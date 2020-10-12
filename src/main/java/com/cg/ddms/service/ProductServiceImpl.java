package com.cg.ddms.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.cg.ddms.dao.LoginDao;
import com.cg.ddms.dao.ProductDao;
import com.cg.ddms.entity.Login;
import com.cg.ddms.entity.Product;
import com.cg.ddms.exception.ProductException;


@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDao productDao;
	
	@Autowired
	LoginDao loginDao;
	
	@Override
	public Login findUser(String username,String password) throws ProductException {

		return loginDao.findUser(username,password);
	}
	
	@Override
	public Product addProduct(Product product) throws ProductException{

		Product prod=productDao.saveAndFlush(product);
		return prod;
	}

	@Override
	public Product findProductById(int productId) throws ProductException {
		Product productStock=null;
		boolean flag=productDao.existsById(productId);
		
		if(flag)
		{
			productStock=productDao.findById(productId).get();
            
		}
		else
		{
			throw new ProductException("id not found");
		}
		
		 return productStock;
	}

	@Override
	public void deleteProductById(int productId) throws ProductException {
		Product productStock=null;
		boolean flag=productDao.existsById(productId);
		
		if(flag)
		{
			productDao.deleteById(productId);   
		}
		else
		{
			throw new ProductException("id not found");
		}
		
	}
}
