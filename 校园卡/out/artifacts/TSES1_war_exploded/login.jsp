<%--
  Created by IntelliJ IDEA.
  User: WJC
  Date: 2021/10/20
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/loginServlet" method="post">
    账号:<input type="text" name="username"><br>
    密码:<input type="password" name="password"><br>
    身份:
    <select name="identity">
        <option value="admin" name="admin">管理员</option>
        <option value="student" name="student">学  生</option>
    </select><br>
    <input type="submit" value="登录" name="login"><br>
</form>
</body>
</html>
