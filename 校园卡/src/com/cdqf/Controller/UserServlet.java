package com.cdqf.Controller;

import com.cdqf.Dao.UserDao;
import com.cdqf.domain.Cardid;
import com.cdqf.domain.User;
import sun.security.provider.certpath.CertId;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {
    UserDao ud=new UserDao();
    User ur=null;
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type=req.getParameter("type");
        System.out.println(type);
        switch (type){
            case "修改密码":
                UpdatePassword(req, resp);
                break;
            case "充值":
                Recharge(req,resp);
                break;
            case "绑定银行卡":
                UpdateCid(req, resp);
                break;
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user=req.getParameter("user");
        System.out.println(user);
        ur=ud.findMy(user);
        req.getSession().setAttribute("user", ur.getUser());
    }

    //改密码
    public void UpdatePassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");
        String user = (String)req.getSession().getAttribute("user");
        String cid = (String)req.getSession().getAttribute("cid");
        System.out.println(user);
        String password=req.getParameter("updatepassword");
        ud.UpdatePassword(user,password);
        req.getRequestDispatcher("/user.jsp?user="+user).forward(req, resp);
    }

    //充值余额
    public void Recharge(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("utf8");
        String user = (String)req.getSession().getAttribute("user");
        String cid=(String)req.getSession().getAttribute("cid");
        String cpassword=req.getParameter("cpassword");
        double num= Double.parseDouble(req.getParameter("num"));
        if(ud.Recharge(cid,cpassword,num)){
            req.getRequestDispatcher("/user.jsp?user="+user+"&cid="+cid).forward(req, resp);
        }else {
            req.getRequestDispatcher("/user.jsp?user="+user+"&cid="+cid).forward(req, resp);
        }
    }

    //绑定银行卡
    public void UpdateCid(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("utf8");
        String user = (String)req.getSession().getAttribute("user");
        String cid=req.getParameter("id");
        String password=req.getParameter("password");
        Cardid cardId=new Cardid(cid,password,0);
        System.out.println(cardId+"  "+password+"  "+cid+"  "+user);
        ud.Cardid(user,cardId);
        req.getRequestDispatcher("/user.jsp?user="+user+"&cid="+cid).forward(req, resp);
    }
}
