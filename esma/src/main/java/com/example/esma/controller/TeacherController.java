package com.example.esma.controller;

import com.example.esma.model.Subject;
import com.example.esma.model.Teacher;
import com.example.esma.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class TeacherController {
    @RequestMapping("/teachers")
    public String teacherPanel(HttpServletRequest request) {
        User user1 = (User) request.getSession().getAttribute("user");
        if (user1 == null || !user1.getRole().equalsIgnoreCase("teacher"))
            return "redirect:/";
        return "/teacher";
    }

}
