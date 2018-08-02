<%--
  Created by IntelliJ IDEA.
  User: south
  Date: 2018/7/31
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>主页</title>
</head>
<body>
    <c:choose>
        <c:when test="${empty sessionScope.sessionUser}">
            您还没有登录！
        </c:when>
        <c:otherwise>
            欢迎您！${sessionScope.sessionUser.username}
        </c:otherwise>
    </c:choose>
</body>
</html>
