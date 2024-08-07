package com.newlecture.web.cohort8th.controller.admin;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newlecture.web.cohort8th.entity.Notice;
import com.newlecture.web.cohort8th.service.NoticeService;

import jakarta.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/admin/notice")
public class NoticeController {

    @Autowired
    private NoticeService service;
    
    @getMapping("list")
    // @ResponseBody
    public void list(HttpServletResponse response) {

        List<Notice> list = service.getList();

        System.out.println(response.toString());
        try {
            // response.sendRedirect("/lecture/list");
            PrintWriter pw = response.getWriter();
            pw.write("Hello");
            
        } catch (IOException e) {            
            e.printStackTrace();
        }
        //return list;

        // return "admin/notice/list";
    }
    
}
