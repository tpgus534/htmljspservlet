package com.kitri.dto;

public class Product {
	private String prod_no;
	private String prod_name;
	private int prod_price;
	private String prod_detail;
	private ProductCategory productCategory;
	public String getProd_no() {
		return prod_no;
	}
	public void setProd_no(String prod_no) {
		this.prod_no = prod_no;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public int getProd_price() {
		return prod_price;
	}
	public void setProd_price(int prod_price) {
		this.prod_price = prod_price;
	}
	public String getProd_detail() {
		return prod_detail;
	}
	public void setProd_detail(String prod_detail) {
		this.prod_detail = prod_detail;
	}
	public ProductCategory getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public Product(String prod_no, String prod_name, int prod_price, String prod_detail,
			ProductCategory productCategory) {
		super();
		this.prod_no = prod_no;
		this.prod_name = prod_name;
		this.prod_price = prod_price;
		this.prod_detail = prod_detail;
		this.productCategory = productCategory;
	}
	@Override
	public String toString() {
		return "Product [prod_no=" + prod_no + ", prod_name=" + prod_name + ", prod_price=" + prod_price
				+ ", prod_detail=" + prod_detail + ", productCategory=" + productCategory + "]";
	}
	
	
	
}
