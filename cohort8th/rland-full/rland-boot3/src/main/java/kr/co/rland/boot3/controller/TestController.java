package kr.co.rland.boot3.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.CookieValue;
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
        cookie.setPath("/");
        cookie.setMaxAge(60*60*24);
        cookie.setHttpOnly(true);
        cookie.setDomain("localhost");
        HttpSession session = request.getSession();
        session.setAttribute("name", name);

        request.getServletContext().setAttribute("name", name);
        response.addCookie(cookie);


        return "Hi";
    }

    @GetMapping("say")
    public String say(HttpServletRequest request, @CookieValue("name") String cookieValue) {

        HttpSession session = request.getSession();

        ServletContext servletContext = request.getServletContext();

//        Cookie[] cookies = request.getCookies();
//        String cookieValue = null;
//        for (Cookie cookie : cookies) {
//            if (cookie.getName().equals("name")) {
//                cookieValue = cookie.getValue();
//            }
//        }

        return "Hi " + session.getAttribute("name")
                + ", application: " + servletContext.getAttribute("name")
                + ", cookie: " + cookieValue;
    }
}
