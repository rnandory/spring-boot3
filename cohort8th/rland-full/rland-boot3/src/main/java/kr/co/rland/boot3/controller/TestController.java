package kr.co.rland.boot3.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("hello")
    public String sayHello() {

        return "Hello World!";
    }

    @GetMapping("hi")
    public String hi(String name, HttpServletRequest request, HttpServletResponse response) {

        Cookie cookie = new Cookie("name", name);
        HttpSession session = request.getSession();
        session.setAttribute("name", name);

        request.getServletContext().setAttribute("name", name);
        response.addCookie(cookie);


        return "Hi";
    }

    @GetMapping("say")
    public String say(HttpServletRequest request) {

        HttpSession session = request.getSession();

        ServletContext servletContext = request.getServletContext();

        return "Hi " + session.getAttribute("name") + ", " + servletContext.getAttribute("name");
    }
}
