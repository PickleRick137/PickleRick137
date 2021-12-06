<%@ page import="com.cdqf.domain.User" %>
<%@ page import="com.cdqf.Dao.UserDao" %><%--
  Created by IntelliJ IDEA.
  User: 73164
  Date: 2021/12/3
  Time: 12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户</title>
</head>
<body>

<%
    String user = request.getParameter("user");
    String cid = request.getParameter("cid");
    UserDao ud=new UserDao();
    User ur=ud.findMy(user);
    session.setAttribute("user",user);
    session.setAttribute("cid",cid);
    if (ur!=null){
            out.print("<table border='1' cellspacing='1'><tr>");
            out.print("<caption>用户信息表</caption>");
            out.print("<tr><th width='60'>用户名</th>"
                    + "<th width='100'>密码</th>"
                    + "<th width='100'>充值</th>"
                    + "<th width='120'>消费</th>"
                    + "<th width='100'>余额</th>"
                    + "<th width='100'>银行卡ID</th>");
            out.print("<tr>");
            out.print("<td>" + ur.getUser()+ "</td>");
            out.print("<td>" + ur.getPassword() + "</td>");
            out.print("<td>" + ur.getBalance() + "</td>");
           out.print("<td>" + ur.getConsumption()+ "</td>");
            out.print("<td>" + ur.getRecharge()+ "</td>");
            out.print("<td>" + ur.getCardid()+ "</td>");
            out.print("</tr>");
          out.print("</table>");
        }
%>

<form action="${pageContext.request.contextPath}/userServlet" method="get">
    充值<br>
    金额:<input type="text" name="num"><br>
    密码:<input type="text" name="cpassword">
    <input type="submit" name="type" value="充值">
</form>

<form action="${pageContext.request.contextPath}/userServlet" method="get">
    输入修改密码:<input type="text" name="updatepassword">
    <input type="submit" name="type" value="修改密码">
</form>

<form action="${pageContext.request.contextPath}/userServlet" method="get">
   <%session.setAttribute("user",user);%>
    绑定银行卡:<input type="text" name="id"><br>
    设定密码:<input type="text" name="password">
    <input type="submit" name="type" value="绑定银行卡">
</form>

<form action="login.jsp">
    <input type="submit" name="type" value="退出">
</form>
</body>
</html>
