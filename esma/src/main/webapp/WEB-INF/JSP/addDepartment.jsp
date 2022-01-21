<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Department</title>
</head>
<body>
<div class="container">
    <form action="/department/add" method="post">
        <label for="departmentName"> department Name</label>
        <input class="inputs" id="departmentName" name="departmentName" placeholder="Department Name" required="true"/> <br/>
        <input type="submit" name="submit" value="Add new department">
    </form>
</div>
</body>
</html>
