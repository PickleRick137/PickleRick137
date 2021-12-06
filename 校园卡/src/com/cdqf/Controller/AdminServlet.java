package com.cdqf.Controller;

import com.cdqf.Dao.AdminDao;
import com.cdqf.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/adminServlet")
public class AdminServlet extends HttpServlet {
    AdminDao ad=new AdminDao();
    User ur=null;
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type=req.getParameter("type");

        switch (type){
            //删除
            case "删除":
                findByUser(req, resp);
                break;
            //添加
            case "添加":
                addUser(req, resp);
                break;
            //修改
            case "修改":
                revise(req, resp);
                break;
            //查找
            case "查找":
                find(req, resp);
                break;
            //退出
            case "退出":
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> Ur=ad.findAll();
        req.getSession().setAttribute("Ur",Ur);
    }

    //删除
    public void findByUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String user=req.getParameter("user");
        System.out.println(user);
        if (user!=null){
            ad.deleteByUser(user);
            req.getRequestDispatcher("/admin.jsp").forward(req, resp);
        }else{
            req.getRequestDispatcher("/admin.jsp").forward(req, resp);
        }
    }

    //添加
    public void addUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double balance= Double.parseDouble(req.getParameter("balance"));
        double consumption= Double.parseDouble(req.getParameter("consumption"));
        double recharge= Double.parseDouble(req.getParameter("recharge"));
        String user=req.getParameter("user");
        String password=req.getParameter("password");
        ur=new User(balance, consumption,recharge, null, user, password);
        ad.addUser(ur);
        req.getRequestDispatcher("/admin.jsp").forward(req, resp);
    }

    //修改
    public void revise(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user=new User(Double.parseDouble(req.getParameter("balance")),
                           Double.parseDouble(req.getParameter("consumption")),
                           Double.parseDouble(req.getParameter("recharge")),
                           null,req.getParameter("user"),req.getParameter("password")
                );
        ad.updateUser(user);
        req.getRequestDispatcher("/admin.jsp").forward(req, resp);
    }

    //查找
    public void find(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user=req.getParameter("user");
        ur=ad.findByUser(user);
        if (ur!=null){
            req.getSession().setAttribute("ur",ur);
            req.getRequestDispatcher("/find.jsp").forward(req, resp);
        }else{
            req.getRequestDispatcher("/admin.jsp").forward(req, resp);
        }
    }
}
