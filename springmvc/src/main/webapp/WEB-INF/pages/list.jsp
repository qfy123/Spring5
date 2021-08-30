<%--
  Created by IntelliJ IDEA.
  User: Random
  Date: 2021/7/17
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%--
    员工列表展示：查询所有员工
    员工列表展示：访问index.jsp-----发送emps请求-----控制器查询所有员工-----放在请求域-----转发到list页面展示
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%
    pageContext.setAttribute("crud",request.getContextPath());
%>
<head>
    <title>员工列表</title>
    <script type="text/javascript" src="${crud}/scripts/jquery-1.9.1.min.js"></script>
</head>
<body>

<h1>员工列表</h1>
<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>lastName</th>
        <th>email</th>
        <th>gender</th>
        <th>departmentName</th>
        <th>编辑</th>
        <th>删除</th>
    </tr>
    <c:forEach items="${emps}" var="emp">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.lastName}</td>
            <td>${emp.email}</td>
            <td>${emp.gender==0?"女":"男"}</td>
            <td>${emp.birth}</td>
            <td>${emp.department.departmentName}</td>
            <td><a href="emps/${emp.id}">编辑</a></td>
            <td><a href="emps/${emp.id}" class="delBtn">删除</a></td>
        </tr>
    </c:forEach>
</table>
<a href="emps/toaddpage">添加员工</a>
<form id="deleteForm" action="" method="post">
    <input type="hidden" name="_method" value="DELETE">
</form>
<script type="text/javascript">
    $(function (){
        $(".delBtn").click(function (){
            $("#deleteForm").attr("action",this.href);
            $("#deleteForm").submit();
            return false;

        })
    })
</script>
</body>
</html>
