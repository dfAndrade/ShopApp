package com.tvb.app.db;

import org.junit.*;
import org.junit.runners.MethodSorters;

import java.sql.ResultSet;
import java.util.Map;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DBInteractionTest {

    @BeforeClass
    public static void onlyOnce() {
        DBInteraction.update("DROP TABLE IF EXISTS test");
    }

    @Test
    public void atableCreationTest() {

        new DBInteraction();
        new DBUtils();

        boolean exists = DBInteraction.checkTable("test");

        Assert.assertFalse(exists);

        int update = DBInteraction.update("CREATE TABLE IF NOT EXISTS test " +
                "(" +
                "id BIGSERIAL," +
                "val VARCHAR(10)" +
                ")"
        );

        Assert.assertEquals(0, update); // 0 for statements that return nothing

        exists = DBInteraction.checkTable("test");

        Assert.assertTrue(exists);
    }

    @Test
    public void btableInsertionSelectTest() {
        String[] params = new String[]{"hi"};
        boolean insert = DBInteraction.insert("test", params);

        Assert.assertTrue(insert);

        ResultSet test = DBInteraction.select(null, "test", null);

        Map<String, String> objMap = DBUtils.resultSetGet1(test);

        Assert.assertNotNull(objMap);

        Assert.assertEquals("1", objMap.get("id"));
        Assert.assertEquals("hi", objMap.get("val"));
    }

    @AfterClass
    public static void tearDown() {
        onlyOnce();
    }
    
}
