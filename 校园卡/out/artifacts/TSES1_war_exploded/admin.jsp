<%@ page import="com.cdqf.domain.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.cdqf.Controller.AdminServlet" %>
<%--
  Created by IntelliJ IDEA.
  User: 73164
  Date: 2021/12/3
  Time: 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员</title>
</head>
<body>
<%
    AdminServlet as=new AdminServlet();
    as.doPost(request,response);
    List<User> Ur = (List<User>) request.getSession().getAttribute("Ur");
    if (Ur!=null){
        out.print("<table border='1' cellspacing='1'><tr>");
        out.print("<caption>用户信息表</caption>");
        out.print("<tr><th width='60'>用户名</th>"
                + "<th width='100'>密码</th>"
                + "<th width='100'>充值</th>"
                + "<th width='120'>消费</th>"
                + "<th width='100'>余额</th>");
        for (User ur:Ur){
            out.print("<tr>");
            out.print("<td>" + ur.getUser()+ "</td>");
            out.print("<td>" + ur.getPassword() + "</td>");
            out.print("<td>" + ur.getBalance() + "</td>");
            out.print("<td>" + ur.getConsumption()+ "</td>");
            out.print("<td>" + ur.getRecharge()+ "</td>");
            out.print("</tr>");
        }
        out.print("</table>");
    }else {
        out.println("数据库连接失败");
    }
%>

<!--ok-->
<form action="add.jsp">
    <input type="submit" name="type" value="添加">
</form>

<form action="${pageContext.request.contextPath}/adminServlet" method="get">
    输入删除用户名:<input type="text" name="user">
    <input type="submit" name="type" value="删除">
</form>

<form action="${pageContext.request.contextPath}/adminServlet">
    输入查找用户名:<input type="text" name="user">
    <input type="submit" name="type" value="查找">
</form>

<form action="revise.jsp">
    输入修改用户名:<input type="text" name="user">
    <input type="submit" name="type" value="修改">
</form>

<form action="revise.jsp">
    <input type="submit" name="type" value="退出">
</form>

</body>
</html>
