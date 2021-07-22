<%--
  Created by IntelliJ IDEA.
  User: Random
  Date: 2021/6/7
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>成功!!!!!!!!!</h1>
<h1>通过map传入数据</h1>
pageContext:${pageScope.msg}<br/>
request:${requestScope.msg}<br/>
session:${sessionScope.msg}<br/>
application:${applicationScope.msg}<br/>
</body>
</html>
