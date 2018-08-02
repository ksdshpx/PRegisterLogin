<%--
  Created by IntelliJ IDEA.
  User: south
  Date: 2018/7/31
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <h1>登录</h1>
    <p style="color: red;font-weight: bold">${msg}</p>
    <form action="<c:url value='/LoginServlet'/>" method="post">
        用户名:<input type="text" name="username" value="${user.username}"/><br/>
        密  码:<input type="password" name="password" value="${user.password}"/><br/>
        <input type="submit" value="登录"/>
    </form>
</body>
</html>
