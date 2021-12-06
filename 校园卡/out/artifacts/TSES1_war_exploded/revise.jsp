<%@ page import="com.cdqf.Controller.AdminServlet" %>
<%@ page import="com.cdqf.Dao.AdminDao" %>
<%@ page import="com.cdqf.domain.User" %><%--
  Created by IntelliJ IDEA.
  User: 73164
  Date: 2021/12/4
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改</title>
</head>
<body>
<%
    String user=request.getParameter("user");
    AdminDao ad=new AdminDao();
    User ur=ad.findByUser(user);
%>
<form action="${pageContext.request.contextPath}/adminServlet" method="get">
    <h4>修改用户</h4>
    <table>
        <tr>
            <td>用户名:</td>
            <td><input type="text" name="user" value="<%=ur.getUser()%>"></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input type="text" name="password" value="<%=ur.getPassword()%>"></td>
        </tr>
        <tr>
            <td>余额:</td>
            <td><input type="text" name="balance" value="<%=ur.getBalance()%>"></td>
        </tr>
        <tr>
            <td>消费:</td>
            <td><input type="text" name="consumption" value="<%=ur.getConsumption()%>"></td>
        </tr>
        <tr>
            <td>充值:</td>
            <td><input type="text" name="recharge" value="<%=ur.getRecharge()%>"></td>
        </tr>
        <tr>
            <th><input type="submit" name="type" value="修改"></th>
        </tr>
    </table>
</form>
</body>
</html>
