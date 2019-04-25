package com.tvb.app.products;

import com.tvb.app.products.attributes.Color;
import com.tvb.app.products.attributes.Size;

public class Clothing extends Product{
	public static final String COLOR_ATTR = "color";
	public static final String SIZE_ATTR = "size";
	private Size size;
	private Color color;
	
	public Clothing() {
		super();
	}

	public Clothing(Color color, Size size) {
		super();
		this.size = size;
		this.color = color;
	}
	
	public void setSize(Size size) {
		this.size = size;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		return super.toString() +
				"Size: "  + this.size  + "\n" +
				"Color: " + this.color + "\n";
	}
	
}
