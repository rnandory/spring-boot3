//package com.newlecture.web.cohort8th.repository;
//
//import com.newlecture.web.cohort8th.entity.Menu;
//import com.newlecture.web.cohort8th.entity.Notice;
//import org.springframework.stereotype.Repository;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
////@Repository
//public class JDBCMenuRepository implements MenuRepository{
//
//    @Override
//    public List<Menu> findAll() {
//        List<Menu> menus = new ArrayList<>();
//
//        String url = "jdbc:oracle:thin:@//hi.newlecture.com:1521/XEPDB1";
//        String sql = "SELECT * FROM MENU";
//
////        Class.forName("oracle.jdbc.driver.OracleDriver");
//
//        try(
//            Connection conn = DriverManager.getConnection(url, "rland", "1128");
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
//            ) {
//            while (rs.next()) {
//
//                long id = rs.getLong("ID");
//                String korName = rs.getString("KOR_NAME");
//                String engName = rs.getString("ENG_NAME");
//                int price = rs.getInt("PRICE");
//                String img = rs.getString("IMG");
//                Date regDate = rs.getDate("REG_DATE");
//                long categoryId = rs.getLong("CATEGORY_ID");
//                long regMemberId = rs.getLong("REG_MEMBER_ID");
//
//                Menu menu = Menu.builder()
//                        .id(id)
//                        .korName(korName)
//                        .engName(engName)
//                        .price(price)
//                        .img(img)
//                        .regDate(regDate)
//                        .categoryId(categoryId)
//                        .regMemberId(regMemberId)
//                        .build();
//
//                menus.add(menu);
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//        return menus;
//    }
//
//    @Override
//    public List<Menu> findAll(Integer categoryId) {
//        return List.of();
//    }
//}
