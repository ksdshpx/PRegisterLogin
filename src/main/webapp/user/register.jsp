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
    <title>注册</title>
    <script type="text/javascript">
        function _change() {
            var imgEle = document.getElementById("vCodeImg");
            imgEle.src = "<c:url value='/VerifyCodeServlet'/>?time=" + new Date().getTime();
        }
    </script>
</head>
<body>
<h1>注册</h1>
<p style="color: red;font-weight: bold">${msg}</p>
    <%--<form action="${pageContext.request.contentPath}/RegisterServlet'/>" method="post">--%>
    <form action="<c:url value='/RegisterServlet'/>" method="post">
        用户名:<input type="text" name="username" value="${user.username}"/>${errors.username}<br/>
        密  码:<input type="password" name="password" value="${user.password}"/>${errors.password}<br/>
        验证码:<input type="text" name="verifyCode" value="${user.verifyCode}" size="3"/>
        <img id="vCodeImg" src="<c:url value="/VerifyCodeServlet"/>"/><a href="#" onclick="_change()">换一张</a>${errors.verifyCode}<br/>
        <input type="submit" value="注册"/>
    </form>
</body>
</html>
