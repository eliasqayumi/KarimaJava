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
    <form action="/subject/add" method="post">
        <label for="subjectName"> Subject Name</label>
        <input class="inputs" id="subjectName" name="subjectName" placeholder="Subject Name" required="true"/> <br/>
        <input type="submit" name="submit" value="Add new Subject">
    </form>
</div>
</body>
</html>
