package com.cdqf.test;

import com.cdqf.Dao.AdminDao;
import com.cdqf.Dao.UserDao;
import com.cdqf.domain.Cardid;
import com.cdqf.domain.User;
import org.junit.Test;

import java.util.List;

public class DaoTest {
    UserDao ud=new UserDao();
    AdminDao ad=new AdminDao();

    //AdminDao登录  ok
    @Test
    public void login(){
        System.out.println(ud.login("123","123456"));
        System.out.println(ad.login("lxy","123456"));
    }

    //AdminDao添加user  ok
    @Test
    public void Recharge(){
        User ur1=new User(0,0,0,null,"5","123");
        User ur2=new User();
        ur2.setUser("5");
        User ur3=null;
        ad.addUser(ur1);
        ad.addUser(ur2);
        ad.addUser(ur3);
    }

    //AdminDao查找所有user  ok
    @Test
    public void findAll(){
        List<User> users =ad.findAll();
        for (User user:users){
            System.out.println(user);
        }
    }

    //AdminDao删除user  ok
    @Test
    public void deleteByUser(){
        ad.deleteByUser("122341");
    }

    //AdminDao查找user  ok
    @Test
    public void findByUser(){
        System.out.println(ad.findByUser("吴金徽"));
        System.out.println(ad.findByUser("李星月"));
    }

    //Admin更改用户ok
    @Test
    public void updateUser(){
        User user=new User(11,11,11,"123","李星月","123456");
        ad.updateUser(user);
    }

    //UserDao充值测试ok
    @Test
    public void Recharge1(){
        ud.Recharge("3","1",10);
        ud.Recharge("3","1",-10);
        ud.Recharge("3","2",10);
        ud.Recharge("3","2",-10);
        ud.Recharge("3",null,0);
    }

    //UserDao绑定银行卡测试ok
    @Test
    public void Card(){
        Cardid card=new Cardid("1","1",1000);
        ud.Cardid("李星月",card);
    }

    //UserDao更改密码 ok
    @Test
    public void UpdatePassword(){
        ud.UpdatePassword("李星月","4321");
    }

    //UserDao查询自己
    @Test
    public void findMyUser(){
       System.out.println(ud.findMy("李星月"));
    }
}
