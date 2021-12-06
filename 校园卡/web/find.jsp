<%@ page import="com.cdqf.domain.User" %><%--
  Created by IntelliJ IDEA.
  User: 73164
  Date: 2021/12/3
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查找</title>
</head>
<body>
<%
    User ur= (User) request.getSession().getAttribute("ur");
    out.print("<table border='1' cellspacing='1'><tr>");
    out.print("<caption>用户信息表</caption>");
    out.print("<tr><th width='60'>用户名</th>"
            + "<th width='100'>密码</th>"
            + "<th width='100'>余额</th>"
            + "<th width='120'>消费</th>"
            + "<th width='100'>充值</th>");
    if (ur!=null) {
        out.print("<tr>");
        out.print("<td>" + ur.getUser() + "</td>");
        out.print("<td>" + ur.getPassword() + "</td>");
        out.print("<td>" + ur.getBalance() + "</td>");
        out.print("<td>" + ur.getConsumption() + "</td>");
        out.print("<td>" + ur.getRecharge() + "</td>");
        out.print("</tr>");
        out.print("</table>");
    }
%>
</body>
</html>
