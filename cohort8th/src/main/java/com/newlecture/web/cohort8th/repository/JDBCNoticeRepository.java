package com.newlecture.web.cohort8th.repository;

import com.newlecture.web.cohort8th.entity.Notice;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class JDBCNoticeRepository implements NoticeRepository{

    @Override
    public List<Notice> findAll() throws SQLException, ClassNotFoundException {

        Class.forName("oracle.jdbc.driver.OracleDriver");
//        Class.forName("oracle.mariadb.jdbc.Driver");

        String url = "jdbc:oracle:thin:@//hi.newlecture.com:1521/XEPDB1";
        Connection conn = DriverManager.getConnection(url, "rland", "20231110");
        Statement stmt = null;
        ResultSet rs = null;

        return List.of();
    }
}
