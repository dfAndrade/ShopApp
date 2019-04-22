package com.tvb.app.products;
import java.util.HashMap;
import java.util.Map;

public abstract class Product {
	private String name;
	private String productCode; //codigo do produto independente de cor/tamanho
	private double price;
	private String productType;
	
	private String quantity;
	
	public Product() {
		
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductCode() {
		return this.productCode;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	public double getPrice() {
		return this.price;
	}
	
	public void setProductType(String type) {
		this.productType = type;
	}
	public String getProductType() {
		return this.productType;
	}
	
	
	public boolean equalsTo(Product product) {
		if(this.name        == product.getName() &&
		   this.productCode == product.getProductCode()) {
			return true;
		}
		else return false;
	}
	
	@Override
	public String toString() {
		StringBuilder strBuild = new StringBuilder();
		strBuild.append("Type: "  + this.productType + "\n");
		strBuild.append("Name: "  + this.name + "\n");
		strBuild.append("Code: "  + this.productCode + "\n");
		strBuild.append("Price: " + String.valueOf(this.price) + "\n");
		return strBuild.toString();
	}
}
