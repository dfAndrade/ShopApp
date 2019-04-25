package com.tvb.app.products;

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
        return this.name.equals(product.getName()) &&
                this.productCode.equals(product.getProductCode());
	}
	
	@Override
	public String toString() {
        return "Type: "   + this.productType + "\n" +
                "Name: "  + this.name        + "\n" +
                "Code: "  + this.productCode + "\n" +
                "Price: " + this.price       + "\n";
	}
}
