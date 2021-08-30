<%--
  Created by IntelliJ IDEA.
  User: Random
  Date: 2021/7/17
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%--
    员工添加：
        在list页面点击“员工添加”-----查询出所有部门信息-----来到添加页面add.jsp，------输入员工数据-----点击保存-----控制器收到员工保存请求-----保存完成后来到列表页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>员工添加</title>
</head>
<body>
<h1>员工添加</h1>
<%--用Spring的表单标签:表单标签可以实现将模型中的属性与HTML表单元素绑定，以实现表单数据更便捷编辑和表单值的回显--%>
<%--SpringMVC认为，表单数据中的每一项最终都是要回显的；
    path指定的是一个属性，这个属性是从隐含模型（请求域）中取出的属性
    path指定的每一个属性，请求域中必须有一个对象，拥有这个属性，这个对象就是请求域中的command

    modelAttribute="":以前表单标签会从请求域中获取一个command对象，把这个对象中的每一个属性对应的显示；现在这个属性可以告诉SpringMVC不要去取command的值，取这个属性指定的对象 --%>
<%
    pageContext.setAttribute("add",request.getContextPath());
%>
<form:form action="${add}/emp" modelAttribute="employee" method="post">
    <%--path:需要写原来html的input的name属性，当作原生的name项，自动回显隐含模型中某个对象对应的属性值--%>
    LastName:<form:input path="lastName"/><form:errors path="lastName"/><br/>
    Email:<form:input path="email"/><form:errors path="email"/><br/>
    Gender:
        男：<form:radiobutton path="gender" value="1"/>
        女：<form:radiobutton path="gender" value="0"/><br/>
    Birth:<form:input path="birth"/><form:errors path="birth"/><br/>
    <%--items:指定要遍历的集合，自动遍历，遍历出的每一个元素都是department对象
        itemLabel：指定遍历出的对象的哪个属性作为option标签体的值
        itemValue：指定遍历出的对象的哪个属性作为要提交的值--%>
    Dept:<form:select path="department.id" items="${depts}" itemLabel="departmentName" itemValue="id"/><br/>
    <input type="submit" value="提交"/>
</form:form>
<%--<form action="">
    LastName:<input type="text" name="lastName"><br/>
    Email:<input type="text" name="email"><br/>
    Gender:<br/>
        男：<input type="radio" name="gender" value="1"><br/>
        女：<input type="radio" name="gender" value="0"><br/>
    Dept:
    <select name="department.id">
        <c:forEach items="${depts}" var="dept">
            <option value="${dept.id}">${dept.departmentName}</option>
        </c:forEach>
    </select>
    <input type="submit" value="提交"/>
</form>--%>
</body>
</html>
