package com.example.esma.controller;

import com.example.esma.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class StudentController {
    @RequestMapping("/students")
    public String studentPanel( HttpServletRequest request) {
        User user1 = (User) request.getSession().getAttribute("user");
        if (user1 == null || !user1.getRole().equalsIgnoreCase("student"))
            return "redirect:/";
        return "/student";
    }
}
