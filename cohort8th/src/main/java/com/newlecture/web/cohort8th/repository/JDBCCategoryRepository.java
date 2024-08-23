package com.newlecture.web.cohort8th.repository;

import com.newlecture.web.cohort8th.entity.Category;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JDBCCategoryRepository implements CategoryRepository {
    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();

        String url = "jdbc:oracle:thin:@//hi.newlecture.com:1521/XEPDB1";
        String sql = "SELECT * FROM CATEGORY";

//        Class.forName("oracle.jdbc.driver.OracleDriver");

        try(
                Connection conn = DriverManager.getConnection(url, "rland", "1128");
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
        ) {
            while (rs.next()) {

                long id = rs.getLong("ID");
                String name = rs.getString("NAME");

                Category category = Category.builder()
                        .id(id)
                        .name(name)
                        .build();

                categories.add(category);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return categories;
    }
}
