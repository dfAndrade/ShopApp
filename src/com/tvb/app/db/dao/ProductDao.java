package com.tvb.app.db.dao;

import com.tvb.app.db.DBInteraction;
import com.tvb.app.db.DBUtils;
import com.tvb.app.products.Product;
import com.tvb.app.products.ProductFactory;

import java.sql.ResultSet;
import java.util.*;

public class ProductDao implements Dao<Product> {

    private List<Product> products = new ArrayList<>();

    public static final String[] KEYS = new String[]{
            "ID",
            "NAME"
            //TODO COMPLETE THIS
    };

    private static final String TABLE_NAME = "table";

    @Override
    public Optional<Product> get(long id) {

        // Get mambo from db
        ResultSet rs = DBInteraction.select(KEYS, TABLE_NAME, "id = " + id);

        // TODO check rs == null ? or.. throw exceptions? *thinking emoji*
        if (rs == null) return Optional.empty();

        // Parse row to map
        Map<String, String> params = DBUtils.resultSetGet1(rs);

        return Optional.ofNullable(ProductFactory.buildProduct(params));
    }

    @Override
    public List<Product> getAll() {

        List<Product> res = null;

        // Get mambo from db
        ResultSet rs = DBInteraction.select(KEYS, TABLE_NAME, null);

        // TODO check rs == null ? or.. throw exceptions? *thinking emoji*
        if (rs == null) return null;

        // Parse row to map
        List<Map<String, String>> rows = DBUtils.resultSet2List(rs);

        return ProductFactory.buildProducts(rows);
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public void update(Product product, String[] params) {
        product.setName(Objects.requireNonNull(params[0], "Error Message (Name cannot be null)"));
        //...

        products.add(product);
    }

    @Override
    public void delete(Product product) {
        products.remove(product);
    }
}
