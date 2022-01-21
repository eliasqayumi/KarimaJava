package com.example.esma.controller;

import com.example.esma.model.*;
import com.example.esma.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
public class AdminController {
    private DepartmentService departmentService;
    private StudentService studentService;
    private StudentInfoService studentInfoService;
    private UserService userService;
    private TeacherService teacherService;
    private TeacherInfoService teacherInfoService;
    private SubjectService subjectService;
    private ManagerService managerService;
    private ManagerInfoService managerInfoService;

    public AdminController(DepartmentService departmentService, StudentService studentService, StudentInfoService studentInfoService, ManagerService managerService,
                           ManagerInfoService managerInfoService, UserService userService, TeacherService teacherService, TeacherInfoService teacherInfoService, SubjectService subjectService) {
        this.departmentService = departmentService;
        this.studentService = studentService;
        this.studentInfoService = studentInfoService;
        this.userService = userService;
        this.teacherService = teacherService;
        this.teacherInfoService = teacherInfoService;
        this.subjectService = subjectService;
        this.managerService = managerService;
        this.managerInfoService = managerInfoService;
    }

    @RequestMapping("/admins")
    public String adminPanel(HttpServletRequest request, Model model) {
        User user1 = (User) request.getSession().getAttribute("user");
        int topla = 0;
        if (user1 == null || !user1.getRole().equalsIgnoreCase("admin"))
            topla = 10;
//            return "redirect:/";

        List<Department> departments = departmentService.findAll();
        List<Student> students = studentService.findAll();
        List<StudentInfo> studentInfos = studentInfoService.findAll();
        List<Manager> managers = managerService.findAll();
        List<ManagerInfo> managerInfos = managerInfoService.findAll();
        List<User> users = userService.findAll();
        List<Teacher> teachers = teacherService.findAll();
        List<TeacherInfo> teacherInfos = teacherInfoService.findAll();
        List<Subject> subjects = subjectService.findAll();

        model.addAttribute("departments", departments);
        model.addAttribute("managerInfos", managerInfos);
        model.addAttribute("managers", managers);
        model.addAttribute("students", students);
        model.addAttribute("studentInfos", studentInfos);
        model.addAttribute("users", users);
        model.addAttribute("teachers", teachers);
        model.addAttribute("teacherInfos", teacherInfos);
        model.addAttribute("subjects", subjects);

        return "admin";
    }


    @RequestMapping("/department/add")
    public String addNewDepartment(HttpServletRequest request) {
//        User user = (User) request.getSession().getAttribute("user");
//        if (user == null || !user.getRole().equalsIgnoreCase("admin"))
//            return "redirect:/";
        long total = departmentService.findAll().size();
        String departmentName = request.getParameter("departmentName");
        String id = "DEP" + total;
        if (departmentName != null) {
            Department newDepartment = new Department(id, departmentName);
            departmentService.insertData(newDepartment);
            return "redirect:/admins";
        }
        return "/addDepartment";
    }

    @RequestMapping("/department/edit/{id}")
    public String updateDepartment(@PathVariable String id, HttpServletRequest request, Model model) {
//        User user = (User) request.getSession().getAttribute("user");
//        if (user == null || !user.getRole().equalsIgnoreCase("admin"))
//            return "redirect:/";
        Department department = departmentService.findById(id);
        model.addAttribute("department", department);
        return "/admin";
    }

    @RequestMapping("/department/update/{id}")
    public String update(@PathVariable String id, @ModelAttribute("department") @Valid Department department, HttpServletRequest request) {
//        User user = (User) request.getSession().getAttribute("user");
//        if (user == null || !user.getRole().equalsIgnoreCase("admin"))
//            return "redirect:/";
        Department updateDepartment = departmentService.findById(id);
        if (department.getName() != null) {
            updateDepartment.setId(id);
            updateDepartment.setName(department.getName());
            departmentService.updateData(updateDepartment);
            return "redirect:/admins";
        }
        return "/admin";
    }

    @RequestMapping("/student/add")
    public String addNewStudent(Model model, HttpServletRequest request) {
//        User user = (User) request.getSession().getAttribute("user");
//        if (user == null || !user.getRole().equalsIgnoreCase("admin"))
//            return "redirect:/";
        List<Department> departments = departmentService.findAll();
        model.addAttribute("departments", departments);
        String departmentId = request.getParameter("department");
        String classIn = request.getParameter("classes");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        System.out.println("name " + name + " surname " + surname + " email " + email + " phone " + phone + " classes " + classIn +" department "+departmentId);
        LocalDate enrolDate = null;
        if (request.getParameter("enrolDate") != null)
            enrolDate = LocalDate.parse(request.getParameter("enrolDate"));
        long studentNo = studentService.findAll().size();
        String studentId = "21" + (studentNo++);
        if (name != null && surname != null && enrolDate != null && phone != null && departmentId != null && email != null && studentId!=null) {
            Student newStudent = new Student(studentId, name, surname, phone, email);
            studentService.insertData(newStudent);
            User newUser = new User(newStudent.getEmail(), newStudent.getPhone(), "student");
            userService.insertData(newUser);
            return "redirect:/admins";
        }
        return "/addStudent";
    }

    @RequestMapping("/student/edit/{id}")
    public String editStudent(@PathVariable String id, @ModelAttribute("student") Student student, HttpServletRequest request, Model model) {
//        User user = (User) request.getSession().getAttribute("user");
//        if (user == null || !user.getRole().equalsIgnoreCase("admin"))
//            return "redirect:/";
        List<Department> departments = departmentService.findAll();
        student = studentService.findStudentById(id);

        StudentInfo studentInfo = studentInfoService.findStudentInfoById(id);
        model.addAttribute("departments", departments);
        model.addAttribute("studentInfo", studentInfo);
        model.addAttribute("student", student);
        return "/admin";
    }

    @RequestMapping("/student/update/{id}")
    public String updateStudent(@PathVariable String id, @ModelAttribute("student") @Valid Student student, HttpServletRequest request) {
//        User user = (User) request.getSession().getAttribute("user");
//        if (user == null || !user.getRole().equalsIgnoreCase("admin"))
//            return "redirect:/";
        Student updateStudent = studentService.findStudentById(id);
        StudentInfo studentInfo = studentInfoService.findStudentInfoById(id);
        LocalDate enrolDate = null;
        if (request.getParameter("enrolDate") != null)
            enrolDate = LocalDate.parse(request.getParameter("enrolDate"));
        String departmentId = request.getParameter("department");
        if (student.getName() != null && student.getSurname() != null && enrolDate != null && student.getPhone() != null && departmentId != null && student.getEmail() != null) {
            updateStudent.setId(id);
            updateStudent.setName(student.getName());
            updateStudent.setSurname(student.getSurname());
            updateStudent.setPhone(student.getPhone());
            updateStudent.setEmail(student.getEmail());
            studentService.updateData(updateStudent);

//            studentInfo.setId(new StudentInfoId(id, enrolDate, departmentId, studentInfo.getId().get_class()));
            studentInfoService.updateData(studentInfo);
            return "redirect:/admins";
        }
        return "/admin";
    }


    @RequestMapping("/user/add")
    public String addNewUser(HttpServletRequest request) {
//        User user1 = (User) request.getSession().getAttribute("user");
//        if (user1 == null || !user1.getRole().equalsIgnoreCase("admin"))
//            return "redirect:/";
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String userRole = request.getParameter("userRole");
        if (email != null && password != null && userRole != null) {
            User newUser = new User(email, password, userRole);
            userService.insertData(newUser);
            return "redirect:/admins";
        }
        return "/admin";
    }

    @RequestMapping("/user/edit/{id}")
    public String updateUser(@PathVariable String id, HttpServletRequest request, Model model) {
//        User user1 = (User) request.getSession().getAttribute("user");
//        if (user1 == null || !user1.getRole().equalsIgnoreCase("admin"))
//            return "redirect:/";
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("admin", "Admin");
        model.addAttribute("teacher", "Teacher");
        model.addAttribute("student", "Student");
        return "/admin";
    }

    @RequestMapping("/user/update/{id}")
    public String update(@PathVariable String id, @ModelAttribute("user") User user, HttpServletRequest request) {
//        User user1 = (User) request.getSession().getAttribute("user");
//        if (user1 == null || !user1.getRole().equalsIgnoreCase("admin"))
//            return "redirect:/";
        User updateUser = userService.findUserById(id);
        if (user.getId() != null && user.getPassword() != null && user.getRole() != null) {
            updateUser.setId(id);
            updateUser.setPassword(user.getPassword());
            updateUser.setRole(user.getRole());
            userService.updateData(updateUser);
            return "redirect:/admins";
        }
        return "/admin";
    }

    //    deleting the userid
    @RequestMapping("/user/delete/{id}")
    public String delete(@PathVariable String id) {
        try {
            userService.deleteData(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/admins";
    }


    @RequestMapping("/teacher/add")
    public String addNewTeacher(Model model, HttpServletRequest request) {
//        User user = (User) request.getSession().getAttribute("user");
//        if (user == null || !user.getRole().equalsIgnoreCase("admin"))
//            return "redirect:/";
        List<Department> departments = departmentService.findAll();
        List<Subject> subjects = subjectService.findAll();
        model.addAttribute("subjects", subjects);
        model.addAttribute("departments", departments);
        LocalDate enrolDate = null;
        if (request.getParameter("enrolDate") != null)
            enrolDate = LocalDate.parse(request.getParameter("enrolDate"));
        String departmentId = request.getParameter("department");
        String subjectId = request.getParameter("subject");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        long total = teacherService.findAll().size();
        String teacherId = "PRO" + total;
        if (name != null && surname != null && enrolDate != null &&
                phone != null && email != null && departmentId != null && subjectId != null) {
            Teacher newTeacher = new Teacher(teacherId, name, surname, phone, email);
            teacherService.insertData(newTeacher);
            teacherInfoService.insertData(new TeacherInfo(new TeacherInfoId(teacherId, enrolDate, departmentId, subjectId)));
            userService.insertData(new User(newTeacher.getEmail(), newTeacher.getPhone(), "teacher"));
            return "redirect:/admins";
        }
        return "/addTeacher";
    }

    @RequestMapping("/teacher/edit/{id}")
    public String editTeacher(@PathVariable String id, @ModelAttribute("teacher") Teacher teacher, HttpServletRequest request, Model model) {
//        User user = (User) request.getSession().getAttribute("user");
//        if (user == null || !user.getRole().equalsIgnoreCase("admin"))
//
//            return "redirect:/";
        TeacherInfo teacherInfo = teacherInfoService.findTeacherInfoById(id);
        List<Department> departments = departmentService.findAll();
        teacher = teacherService.findTeacherById(id);
        model.addAttribute("teacherInfo", teacherInfo);
        model.addAttribute("departments", departments);
        model.addAttribute("teacher", teacher);
        return "/admin";
    }

    @RequestMapping("/teacher/update/{id}")
    public String updateTeacher(@PathVariable String id, @ModelAttribute("teacher") @Valid Teacher teacher, HttpServletRequest request) {
//        User user = (User) request.getSession().getAttribute("user");
//        if (user == null || !user.getRole().equalsIgnoreCase("admin"))
//            return "redirect:/";
        Teacher updateTeacher = teacherService.findTeacherById(id);
        TeacherInfo teacherInfo = teacherInfoService.findTeacherInfoById(teacher.getId());
        LocalDate enrolDate = null;
        if (request.getParameter("enrolDate") != null)
            enrolDate = LocalDate.parse(request.getParameter("enrolDate"));
        String departmentId = request.getParameter("department");
        String subjectId = request.getParameter("subject");
        if (teacher.getName() != null && teacher.getSurname() != null && enrolDate != null &&
                teacher.getPhone() != null && teacher.getEmail() != null && departmentId != null) {
            System.out.println(departmentId);
            updateTeacher.setId(id);
            updateTeacher.setName(teacher.getName());
            updateTeacher.setSurname(teacher.getSurname());
            updateTeacher.setPhone(teacher.getPhone());
            updateTeacher.setEmail(teacher.getEmail());
            teacherService.updateData(teacher);

            TeacherInfoId teacherInfoId = teacherInfo.getId();
            teacherInfoId.setTeacherId(id);
            teacherInfoId.setRecord(enrolDate);
            teacherInfoId.setSubjectId(subjectId);
            teacherInfo.setId(teacherInfoId);
            teacherInfoService.updateData(teacherInfo);

            return "redirect:/admins";
        }
        return "/admin";
    }


    @RequestMapping("/subject/add")
    public String addNewSubject(HttpServletRequest request) {
//        User user = (User) request.getSession().getAttribute("user");
//        if (user == null || !user.getRole().equalsIgnoreCase("admin"))
//            return "redirect:/";
        String subjectName = request.getParameter("subjectName");
        long total = subjectService.findAll().size();
        String id = "DER" + total;
        if (subjectName != null) {
            Subject newSubject = new Subject(id, subjectName);
            subjectService.insertData(newSubject);
            return "redirect:/admins";
        }
        return "/addSubject";
    }

    @RequestMapping("/subject/edit/{id}")
    public String editSubject(@PathVariable String id, @ModelAttribute("subject") Subject subject, HttpServletRequest request, Model model) {
//        User user = (User) request.getSession().getAttribute("user");
//        if (user == null || !user.getRole().equalsIgnoreCase("admin"))
//            return "redirect:/";
        subject = subjectService.findSubjectById(id);
        model.addAttribute("subject", subject);
        return "admin/update/updateSubject";
    }

    @RequestMapping("/subject/update/{id}")
    public String updateSubject(@PathVariable String id, @ModelAttribute("subject") @Valid Subject subject, HttpServletRequest request) {
//        User user = (User) request.getSession().getAttribute("user");
//        if (user == null || !user.getRole().equalsIgnoreCase("admin"))
//            return "redirect:/";
        Subject updatedSubject = subjectService.findSubjectById(id);
        if (subject.getId() != null && subject.getName() != null) {
            updatedSubject.setId(id);
            updatedSubject.setName(subject.getName());
            subjectService.updateData(updatedSubject);
            return "redirect:/admins";
        }
        return "/admin";
    }

    @RequestMapping("/manager/add")
    public String addNewManager(Model model, HttpServletRequest request) {
//        User user = (User) request.getSession().getAttribute("user");
//        if (user == null || !user.getRole().equalsIgnoreCase("admin"))
//            return "redirect:/";
        List<Department> departments = departmentService.findAll();
        model.addAttribute("departments", departments);
        LocalDate enrolDate = null;
        if (request.getParameter("enrolDate") != null)
            enrolDate = LocalDate.parse(request.getParameter("enrolDate"));

        String departmentId = request.getParameter("department");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        long total = studentService.findAll().size();
        String managerId = "ADM" + total;

        if (name != null && surname != null && enrolDate != null && phone != null && email != null) {
            Manager newManager = new Manager(managerId, name, surname, phone, email);
            ManagerInfoId managerInfoId = new ManagerInfoId(managerId, enrolDate, departmentId);
            ManagerInfo managerInfo = new ManagerInfo();
            managerInfo.setId(managerInfoId);
            User newUser = new User(managerId, phone, "admin");
            managerService.insertData(newManager);
            managerInfoService.insertData(managerInfo);
            userService.insertData(newUser);
            return "redirect:/admins";
        }
        return "/addManager";
    }

    @RequestMapping("/manager/edit/{id}")
    public String editManager(@PathVariable String id, @ModelAttribute("student") Student student, HttpServletRequest request, Model model) {
//        User user = (User) request.getSession().getAttribute("user");
//        if (user == null || !user.getRole().equalsIgnoreCase("admin"))
//            return "redirect:/";
        List<Department> departments = departmentService.findAll();
        student = studentService.findStudentById(id);
        StudentInfo studentInfo = studentInfoService.findStudentInfoById(id);
        model.addAttribute("departments", departments);
        model.addAttribute("studentInfo", studentInfo);
        model.addAttribute("student", student);
        return "/admin";
    }

    @RequestMapping("/manager/update/{id}")
    public String updateManager(@PathVariable String id, @ModelAttribute("student") @Valid Student student, HttpServletRequest request) {
//        User user = (User) request.getSession().getAttribute("user");
//        if (user == null || !user.getRole().equalsIgnoreCase("admin"))
//            return "redirect:/";
        Student updateStudent = studentService.findStudentById(id);
        StudentInfo studentInfo = studentInfoService.findStudentInfoById(id);
        LocalDate enrolDate = null;
        if (request.getParameter("enrolDate") != null)
            enrolDate = LocalDate.parse(request.getParameter("enrolDate"));
        String departmentId = request.getParameter("department");
        if (student.getName() != null && student.getSurname() != null && enrolDate != null && student.getPhone() != null && departmentId != null && student.getEmail() != null) {
            updateStudent.setId(id);
            updateStudent.setName(student.getName());
            updateStudent.setSurname(student.getSurname());
            updateStudent.setPhone(student.getPhone());
            updateStudent.setEmail(student.getEmail());
            studentService.updateData(updateStudent);

            studentInfoService.updateData(studentInfo);
            return "redirect:/admins";
        }
        return "/admin";
    }

}
