package com.cdqf.Dao;

import com.cdqf.Utils.DruidUtil;
import com.cdqf.domain.Cardid;
import com.cdqf.domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
    public User u = null;
    private JdbcTemplate jt = new JdbcTemplate(DruidUtil.getDataSource());

    //登录 test
    public User login(String user, String password) {
        String sql = "select * from user where user=? and password=?";
        try {
            u = jt.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return u;
    }

    //展示自己信息 test
    public User findMy(String user) {
        String sql = "select * from user where user=?";
        try {
            u=jt.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return u;
    }

    //改密码 test
    public void UpdatePassword(String user,String password){
        String sql="update user set password =? where user =?";
        try {
            jt.update(sql,password,user);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    //绑定银行卡 test
    public void Cardid(String user, Cardid card){
        String sql1="insert into cardid(id,password,deposit) values(?,?,?)";
        String sql2="update user set cardid=? where user=?";
        try {
            jt.update(sql1,card.getCid(),card.getCpassword(),card.getDeposit());
            jt.update(sql2,card.getCid(),user);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    //充值 test
    public boolean Recharge(String id,String cpassword,double num) {
        double i;
        String sql1 = "select deposit from cardid where id=? and password=? ";
        String sql2 = "update cardid set deposit=deposit-? where id=?";
        String sql3 = "update user set recharge=recharge+?,balance=? where cardid=?";
        try {
            i= jt.queryForObject(sql1,Double.class,id,cpassword);
            if (i>num){
                jt.update(sql2,num,id);
                jt.update(sql3,num,num,id);
                return true;
            }else{
                return false;
            }
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
