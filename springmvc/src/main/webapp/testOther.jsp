<%--
  Created by IntelliJ IDEA.
  User: Random
  Date: 2021/8/24
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
</head>
<body>
<form action="testRequestBody" method="post">
    <input name="username" value="tomcat"/>
    <input name="password" value="123456"/>
    <input type="submit"/>

</form>
<a href="testRequestBody">ajax发送json数据</a>
<script type="text/javascript">
    $("a:first").click(function (){
        //点击发送ajax请求，请求带的数据是json
        var emp={lastName:"张三",email:"aaa@aa.com",gender:"0"};
        var empStr=JSON.stringify(emp);
        $.ajax({
            url:"testRequestBody",
            type:"POST",
            data:empStr,
            contentType:"application/json",
            success:function (data){
                alert(data)
            }
        })
        return false;
    })
</script>
</body>
</html>
