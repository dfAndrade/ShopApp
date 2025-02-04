package com.tvb.app.products;

import com.tvb.app.products.attributes.Color;
import com.tvb.app.products.attributes.Size;

public class Testing {

	public static void main(String[] args) {
		Stock stock = new Stock();
		
		Clothing prod1 = new Clothing();
		prod1.setName("Camisola 1");
		prod1.setProductCode("cami_verano");
		prod1.setProductType("camisola");
		prod1.setPrice(32.99);
		prod1.setSize(new Size("S"));
		prod1.setColor(new Color("Red"));
		
		Clothing prod2 = new Clothing();
		prod2.setName("Casaco 1");
		prod2.setProductCode("casac_inver");
		prod2.setProductType("casaco");
		prod2.setPrice(98.99);
		prod2.setSize(new Size("M"));
		prod2.setColor(new Color("Black"));
		
		
		stock.addProduct(prod1);
		stock.addProduct(prod2);
				
		System.out.println(stock.toString());

	}

}
