package com.cdqf.Controller;

import com.cdqf.Dao.AdminDao;
import com.cdqf.Dao.UserDao;
import com.cdqf.domain.Admin;
import com.cdqf.domain.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置字符
        req.setCharacterEncoding("utf8");
        //取值
        String user=req.getParameter("username");
        String password=req.getParameter("password");
        String identity=req.getParameter("identity");
        if(identity.equals("admin")){
            //调用Dao进行sql查询与判断
            AdminDao dao=new AdminDao();
            if (dao.login(user,password)){
                req.getRequestDispatcher("/admin.jsp").forward(req, resp);
            }else{
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }
        }else{
            //调用Dao进行sql查询与判断
            UserDao dao=new UserDao();
            User ur=dao.login(user,password);
            if (ur!=null){
                req.getRequestDispatcher("/user.jsp?user="+ur.getUser()+"&cid="+ur.getCardid()).forward(req, resp);
            }else{
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
