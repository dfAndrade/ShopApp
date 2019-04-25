package com.tvb.app.products;

import com.tvb.app.products.attributes.Color;
import com.tvb.app.products.attributes.Size;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductFactory {


    // TODO maybe add properties to the enum like number of args
    public enum ProductType {
        CLOTHING
    }

    public static Product buildProduct(Map<String, String> params) {
        Product p = null;
        ProductType type = ProductType.valueOf(params.get("type"));

        switch (type) {
            case CLOTHING:
                p = new Clothing(
                        new Color(params.get(Clothing.COLOR_ATTR)),
                        new Size(params.get(Clothing.SIZE_ATTR)));
                break;
            default:
                System.out.println("Invalid type");
        }

        return p;
    }

    public static List<Product> buildProducts(List<Map<String, String>> paramList) {
        List<Product> res = new ArrayList<>();
        for (Map<String, String> params : paramList) {
            res.add(buildProduct(params));
        }
        return res;
    }
}
