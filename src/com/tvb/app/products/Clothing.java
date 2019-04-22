package com.tvb.app.products;

public class Clothing extends Product{
	private String size;
	private String color;
	
	public Clothing() {
		super();
	}
	
	public void setSize(String size) {
		this.size = size;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		StringBuilder strBuild = new StringBuilder();
		strBuild.append(super.toString());
		strBuild.append("Size: "   + this.size  + "\n");
		strBuild.append("Color: "  + this.color + "\n");
		return strBuild.toString();
	}
	
}
