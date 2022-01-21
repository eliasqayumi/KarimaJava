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
    <form action="/user/add" method="post">
        <label for="email"> Email</label>
        <input class="inputs" id="email" name="email" placeholder="Email" required="true"/> <br/>
        <label for="password"> Password</label>
        <input class="inputs" id="password" name="password" placeholder="password" required="true"/> <br/>
        <label for="role"> Role</label>
        <input class="inputs" id="role" name="role" placeholder="role" required="true"/> <br/>
        <input type="submit" name="submit" value="Add new Subject">
    </form>
</div>
</body>
</html>
