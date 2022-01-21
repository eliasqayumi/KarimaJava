<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Subject</title>
</head>
<body>
<div class="container">
    <form action="/teacher/add" method="post">
        <label for="name">FirstName</label>
        <input class="inputs" id="name" name="name" placeholder="Firstname" required/> <br/>
        <label for="surname">Surname</label>
        <input type="text" id="surname" name="surname" placeholder="Surname" required><br>
        <label for="phone">Phone</label>
        <input type="text" id="phone" name="phone" placeholder="Phone" required><br>
        <label for="email">Email</label>
        <input type="email" id="email" name="email" placeholder="example@mail.com" required><br>
        <label for="department">Department</label>
        <select name="department" id="department">
            <c:forEach var="department" items="${departments}">
                <option value="${department.id}">${department.name}</option>
            </c:forEach>
        </select>
        <label for="subject">Subject</label>
        <select name="subject" id="subject">
            <c:forEach var="subject" items="${subjects}">
                <option value="${subject.id}">${subject.name}</option>
            </c:forEach>
        </select>
        <input type="submit" name="submit" value="Add new Subject">
    </form>
</div>
</body>
</html>
