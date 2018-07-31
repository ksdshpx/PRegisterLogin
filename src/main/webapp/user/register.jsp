<%--
  Created by IntelliJ IDEA.
  User: south
  Date: 2018/7/31
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
    <h1>注册</h1>
    <%--<form action="${pageContext.request.contentPath}/RegisterServlet'/>" method="post">--%>
    <form action="<c:url value='/RegisterServlet'/>" method="post">
        用户名:<input type="text" name="username"/><br/>
        密  码:<input type="password" name="password"/><br/>
        <input type="submit" value="注册"/>
    </form>
</body>
</html>
