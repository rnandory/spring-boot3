package com.newlecture.web.cohort8th.repository;

import com.newlecture.web.cohort8th.entity.Notice;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class JDBCNoticeRepository implements NoticeRepository{

    public static void main(String[] args) {
        NoticeRepository repo = new JDBCNoticeRepository();
        List<Notice> list = repo.findAll();
        System.out.println(list);
    }

    @Override
    public List<Notice> findAll() {
        List<Notice> notices = new ArrayList<Notice>();

        String url = "jdbc:oracle:thin:@//hi.newlecture.com:1521/XEPDB1";
        String sql = "SELECT * FROM NOTICE";

        try(
                Connection conn = DriverManager.getConnection(url, "rland", "0530");
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
        ) {
//            Class.forName("oracle.jdbc.driver.OracleDriver");

            while (rs.next()) {

                long id = rs.getInt("ID");
                String title = rs.getString("TITLE");
                String content = rs.getString("CONTENT");
                Date regDate = rs.getDate("REG_DATE");
                Date updateDate = rs.getDate("UPDATE_DATE");
                int hitCount = rs.getInt("HIT_COUNT");
                int regMemberId = rs.getInt("REG_MEMBER_ID");

                Notice notice = Notice.builder()
                        .id(id)
                        .title(title)
                        .content(content)
                        .regDate(regDate)
                        .updateDate(updateDate)
                        .hitCount(hitCount)
                        .regMemberId(regMemberId)
                        .build();

                notices.add(notice);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return notices;
    }
}
