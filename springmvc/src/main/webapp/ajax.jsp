<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Random
  Date: 2021/8/24
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>

</head>
<body>
<%=new Date()%>
<a href="getallajax">ajax获取所有员工</a><br/>
<div>

</div>
<script type="text/javascript" >
    $("a:first").click(function (){
        //1、发送ajax请求获取所有员工
        $.ajax({
            url:"getallajax",
            type:"GET",
            success:function (data){
                $.each(data,function (){
                    var empInfo=this.lastName+"-->"+this.birth+"-->"+this.gender
                    $("div").append(empInfo+"<br/>")
                })
            }
        })
        return false;
    })
</script>
</body>
</html>
