package com.example.esma.controller;

import com.example.esma.model.User;
import com.example.esma.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class AppController {
    private UserService userService;

    public AppController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String home(Model model, HttpServletRequest request) {
        request.getSession().invalidate();
        String username = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null)
            for (Cookie cookie : cookies)
                if (cookie.getName().equals("user"))
                    username = cookie.getValue();
        model.addAttribute("username", username);
        return "index";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response, Model model) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            User user = userService.findUserByUserEmail(username);
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (!cookie.getName().equals("user")) {
                        Cookie newCookie = new Cookie("user", username);
                        newCookie.setMaxAge(60 * 60 * 24);
                        response.addCookie(newCookie);
                    }
                }
            }
            if (user.getPassword().equals(password)) {
                request.getSession().invalidate();
                HttpSession newSession = request.getSession();
                newSession.setMaxInactiveInterval(2000);
                String encode = response.encodeURL(request.getContextPath());
                model.addAttribute("user", user);
                newSession.setAttribute("user", user);
                return "redirect:" + encode + user.getRole().toLowerCase() + "s";
            }

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/";
    }

}
