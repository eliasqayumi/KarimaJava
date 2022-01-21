<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Admin</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="<c:url value="/admin.css"/> ">

</head>
<body>
<div class="limiter">
    <div class="container">
        <div class="contain">


            <div class="wrap">
                <span class="title">
                    Subjects
                </span>
                <span>
                    <a class="add" href="/subject/add">Add new Subject</a>
                </span>
                <div class="pack">
                    <table>
                        <tr>
                            <th>ID</th>
                            <th>Subject Name</th>
                            <th>Action</th>
                        </tr>
                        <c:forEach var="subject" items="${subjects}">
                            <tr>
                                <td>${subject.id}</td>
                                <td>${subject.name}</td>
                                <td><a class="updateBttn" href="/subject/edit/${student.id}" class="replay">Update</a>
                                    <a class="deleteBttn" href="/subject/delete/${student.id}" class="replay">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
            <div class="wrap">
            <span class="title">
                Department
            </span>
                <span>
                    <a class="add" href="/department/add">Add new Department</a>
                </span>
                <div class="pack">
                    <table>
                        <tr>
                            <th>ID</th>
                            <th>Department Name</th>
                            <th>Action</th>
                        </tr>
                        <c:forEach var="department" items="${departments}">
                            <tr>
                                <td>${department.id}</td>
                                <td>${department.name}</td>
                                <td><a class="updateBttn" href="/department/edit/${department.id}"
                                       class="replay">Update</a>
                                    <a class="deleteBttn" href="/teacher/delete/${student.id}" class="replay">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>

        <div class="contain">

            <div class="wrap">
                <span class="title">
                    Students
                </span>
                <span>
                    <a class="add" href="/student/add">Add new Student</a>
                </span>
                <div class="pack">
                    <table>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Surname</th>
                            <th>Email</th>
                            <th>Contact</th>
                            <th>Enrol Date</th>
                            <th>Action</th>
                        </tr>
                        <c:forEach var="student" items="${students}">
                            <tr>
                                <td>${student.id}</td>
                                <td>${student.name}</td>
                                <td>${student.surname}</td>
                                <td>${student.email}</td>
                                <td>${student.phone}</td>
                                <c:forEach var="studentInfo" items="${studentInfos}">
                                    <c:if test="${student.id==studentInfo.id.studentId}">
                                        <td>${studentInfo.id.record}</td>
                                    </c:if>
                                </c:forEach>
                                <td><a class="updateBttn" href="/student/edit/${student.id}" class="replay">Update</a>
                                    <a class="deleteBttn" href="/student/delete/${student.id}" class="replay">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>

            <div class="wrap">
                <span class="title">
                    User
                </span>
                <span>
                    <a class="add" href="/user/add">Add new User</a>
                </span>
                <div class="pack">
                    <table>
                        <tr>
                            <th>id</th>
                            <th>Password</th>
                            <th>User Role</th>
                            <th>Action</th>
                        </tr>
                        <c:forEach var="user" items="${users}">
                            <tr>
                                <td>${user.id}</td>
                                <td>${user.password}</td>
                                <td>${user.role}</td>
                                <td><a class="updateBttn" href="/user/update/${user.id}" class="replay">Update</a>
                                    <a class="deleteBttn" href="/user/delete/${user.id}" class="replay">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>

            </div>
        </div>
        <div class="contain">

            <div class="wrap">
                <span class="title">
                    Teachers
                </span>
                <span>
                    <a class="add" href="/teacher/add">Add new Teacher</a>
                </span>
                <div class="pack">
                    <table>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Surname</th>
                            <th>Email</th>
                            <th>Contact</th>
                            <th>Enrol Date</th>
                            <th>Action</th>
                        </tr>
                        <c:forEach var="teacher" items="${teachers}">
                            <tr>
                                <td>${teacher.id}</td>
                                <td>${teacher.name}</td>
                                <td>${teacher.surname}</td>
                                <td>${teacher.email}</td>
                                <td>${teacher.phone}</td>
                                <c:forEach var="teacherInfo" items="${teacherInfos}">
                                    <c:if test="${teacher.id==teacherInfo.id.teacherId}">
                                        <td>${teacherInfo.id.record}</td>
                                    </c:if>
                                </c:forEach>
                                <td><a class="updateBttn" href="/teacher/edit/${teacher.id}" class="replay">Update</a>
                                    <a class="deleteBttn" href="/teacher/delete/${teacher.id}" class="replay">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>


            <div class="wrap">
                <span class="title">
                    Managers
                </span>
                <span>
                    <a class="add" href="/manager/add">Add new Manager</a>
                </span>
                <div class="pack">
                    <table>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Surname</th>
                            <th>Email</th>
                            <th>Contact</th>
                            <th>Enrol Date</th>
                            <th>Action</th>
                        </tr>
                        <c:forEach var="manager" items="${managers}">
                            <tr>
                                <td>${manager.id}</td>
                                <td>${manager.name}</td>
                                <td>${manager.surname}</td>
                                <td>${manager.email}</td>
                                <td>${manager.phone}</td>
                                <c:forEach var="managerInfo" items="${managerInfos}">
                                    <c:if test="${manager.id==managerInfo.id.managerId}">
                                        <td>${managerInfo.id.record}</td>
                                    </c:if>
                                </c:forEach>
                                <td><a class="updateBttn" href="/student/edit/${manager.id}" class="replay">Update</a>
                                    <a class="deleteBttn" href="/teacher/delete/${manager.id}" class="replay">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>

    </div>
</div>


</body>
</html>