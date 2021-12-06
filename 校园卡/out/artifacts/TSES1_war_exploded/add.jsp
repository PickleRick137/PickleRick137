<%--
  Created by IntelliJ IDEA.
  User: 73164
  Date: 2021/12/2
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/adminServlet" method="get">
    <h4>添加用户</h4>
    <table>
        <tr>
            <td>用户名:</td>
            <td><input type="test" name="user"></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input type="text" name="password"></td>
        </tr>
        <tr>
            <td>余额:</td>
            <td><input type="text" name="balance"></td>
        </tr>
        <tr>
            <td>消费:</td>
            <td><input type="text" name="consumption"></td>
        </tr>
        <tr>
            <td>充值:</td>
            <td><input type="text" name="recharge"></td>
        </tr>
        <tr>
            <th><input type="submit" name="type" value="添加"></th>
        </tr>
    </table>
</form>

</body>
</html>
