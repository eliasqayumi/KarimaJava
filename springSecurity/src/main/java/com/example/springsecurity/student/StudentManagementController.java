package com.example.springsecurity.student;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {
    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "James bond"),
            new Student(2, "Maria Jones"),
            new Student(3, "Anna Smith")
    );
    @GetMapping("/getAll")
    public List<Student> getStudents() {
        return STUDENTS;
    }
    @PostMapping("/save")
    public String registerNewStudent(@RequestBody  Student student) {
//        STUDENTS.add(student);
        return "saved";
    }
    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable Integer studentId){
        System.out.println(studentId);
    }
    @PutMapping("/{studentId}")
    public void updateStudent(@PathVariable Integer studentId,@RequestBody Student student){
        System.out.println(String.format("%s %s",studentId,student));
    }
}
