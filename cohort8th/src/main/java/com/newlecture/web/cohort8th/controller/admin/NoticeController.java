package com.newlecture.web.cohort8th.controller.admin;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newlecture.web.cohort8th.entity.Notice;
import com.newlecture.web.cohort8th.service.NoticeService;

import jakarta.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/admin/notice")
public class NoticeController {

    @Autowired
    private NoticeService service;
    
    @GetMapping("list")
    // @ResponseBody
    public String list(
//            HttpServletResponse response
            // /admin/notice/list?p=1
            @RequestParam(name = "p", defaultValue = "1") Integer page,
            Model model
    ) throws SQLException, ClassNotFoundException {

        int offset = page + 1;

        List<Notice> notices = service.getList();
        model.addAttribute("notices", notices);
        model.addAttribute("test", "hello");

        return "admin/notice/list";
    }
    
}
