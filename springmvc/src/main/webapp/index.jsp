<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello">你好</a><br/>
<h1>@RequestMapping测试</h1>
<a href="handle01">handle01测试</a><br/>
<h1>测试@RequestMapping的其他属性</h1>
<a href="handle02">handle02测试method属性</a><br/>
<form action="handle02" method="post">
    <input type="submit">
</form>
<a href="handle03">handle03测试params属性</a><br/>
<a href="handle04">handle04测试headers属性</a><br/>
<h1>RequestMapping-Ant风格的URL</h1>
<a href="urlTest01">精准请求地址</a>
<a href="user/{id}">测试PathVariable</a>
<h1>-----------------------------------------------</h1>
<%--
    REST风格使增删改查操作的url地址变得更简洁
    之前的书城项目中，对图书的增删改查对应四个地址:addBook,updateBook,deleteBook,queryBook
    现在使用REST风格后：
        请求url      请求方式    表示含义
        /book/1     get        查询1号图书
        /book/1     delete     删除1号图书
        /book/1     put        更新1号图书
        /book       post       添加图书

    如何从页面发起put和delete请求？Spring提供了对REST风格的支持
    SpringMVC有一个Filter，可以把普通的请求转化为规定形式的请求
    然后创建一个post类型的表单，表单项中带上_method的参数，这个参数的值就是delete或者put
    --%>
<a href="book/1">查询图书</a><br/>
<form method="post" action="book">
    <input type="submit" value="添加图书">
</form><br/>
<form action="book/1" method="post">
    <input name="_method" value="delete"/>
    <input type="submit" value="删除1号图书"/>
</form><br/>
<form action="book/1" method="post">
    <input name="_method" value="put"/>
    <input type="submit" value="更新1号图书"/>
</form><br/>
<h1>-----------------------------------------------</h1>
<a href="requestTest01?user=adasda">RequestParam测试</a>
<h1>-----------------------------------------------</h1>
<form action="book" method="post">
    书名：<input type="text" name="bookName"/><br/>
    作者：<input type="text" name="author"/><br/>
    价格：<input type="text" name="price"/><br/>
    库存：<input type="text" name="stock"/><br/>
    销量：<input type="text" name="sales"/><br/>
    <input type="submit">
</form>
<h1>-----------------------------------------------</h1>
<a href="output01">SpringMVC将数据通过map传入页面测试</a><br/>
<a href="output02">SpringMVC将数据通过model传入页面测试</a><br/>
<a href="output03">SpringMVC将数据通过modelMap传入页面测试</a><br/>
<a href="output04">SpringMVC将数据通过modelAndView传入页面测试</a><br/>
<h1>-----------------------------------------------</h1>
<a href="view01">测试forward前缀</a><br/>
<a href="view02">测试forward的多次转发</a><br/>
<a href="view03">测试redirect前缀</a><br/>
<a href="view04">测试jstlView快速国际化</a><br/>
<a href="toLoginPage">测试mvc请求映射</a><br/>
<a href="handleplus">测试自定义视图解析器</a><br/>
<h1>-----------------------------------------------</h1>
<a href="emps">SpringMVC的CRUD--转到员工列表</a>
</body>
</html>