package com.cg.ddms.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="product_tbl")
public class Product {
	
	@Id
	@GeneratedValue(generator="mygen",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="mygen",sequenceName="product_seq",allocationSize=1)
	@Column(name="product_id")
	private int productId;
	
	@Column(name="product_name",length=15)
	private String productName;
	
	@Column(name="price")
	private double price;
	
	
//	@Temporal(TemporalType.DATE)
//	@DateTimeFormat(pattern = "yyyy/MM/dd")
//	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
//	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern ="yyyy/MM/dd")
	@Column(name="manufacturingdate")
	private Date manufacturingdate;
	
	

//	@Temporal(TemporalType.DATE)
//	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
//	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern ="yyyy/MM/dd")
	@Column(name="expirydate")
	private Date expirydate;
	
	

	public Product(int productId, String productName, double price, Date manufacturingdate, Date expirydate) {
	super();
	this.productId = productId;
	this.productName = productName;
	this.price = price;

	this.manufacturingdate = manufacturingdate;
	this.expirydate = expirydate;
}

	public Product() {
		super();
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductStock [productId=" + productId + ", productName=" + productName + ", price=" + price + "]";
	}

	

	public Date getManufacturingdate() {
		return manufacturingdate;
	}

	public void setManufacturingdate(Date manufacturingdate) {
		this.manufacturingdate = manufacturingdate;
	}

	public Date getExpirydate() {
		return expirydate;
	}

	public void setExpirydate(Date expirydate) {
		this.expirydate = expirydate;
	}

	
	
}
