<%--
  Created by IntelliJ IDEA.
  User: Random
  Date: 2021/7/22
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>员工编辑</title>
</head>
<body>
<h1>员工编辑</h1>
<form:form action="" modelAttribute="employee" method="post">
    <input type="hidden" name="_method" value="put"/>
    <input type="hidden" name="id" value="${employee.id}">
    Email:<form:input path="email"/><br/>
    Gender:
    男：<form:radiobutton path="gender" value="1"/>
    女：<form:radiobutton path="gender" value="0"/><br/>
    Dept:<form:select path="department.id" items="${depts}" itemLabel="departmentName" itemValue="id"/><br/>
    <input type="submit" value="提交"/>
</form:form>
</body>
</html>
