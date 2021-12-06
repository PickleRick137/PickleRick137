package com.cdqf.Dao;

import com.cdqf.Utils.DruidUtil;
import com.cdqf.domain.Admin;
import com.cdqf.domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

public class AdminDao {
    public Admin a=null;
    private JdbcTemplate jt=new JdbcTemplate(DruidUtil.getDataSource());

    //登录
    public boolean login(String user, String  password){
        String sql="select * from admin where user=? and password=?";
        try {
            a = jt.queryForObject(sql, new BeanPropertyRowMapper<Admin>(Admin.class), user, password);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //查找所有
    public List<User> findAll(){
        List user=null;
        String sql="select * from user";
        user=jt.query(sql,new BeanPropertyRowMapper<User>(User.class));
        return user;
    }

    //根据User删
    public boolean deleteByUser(String user) {
        String sql1 = "select cardid from user where user=?";
        String sql2 = "delete from user where user = ?";
        String sql3 = "delete from cardid where id = ?";
        try {
            String cid=jt.queryForObject(sql1,String.class,user);
            jt.update(sql2, user);
            jt.update(sql3,cid);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //添加User
    public void addUser(User user){
        String sql1 = "insert into user(user,password,balance,consumption,recharge) values(?,?,?,?,?)";
        jt.update(sql1,user.getUser(),user.getPassword(),user.getBalance(), user.getConsumption(), user.getRecharge());
    }

    //查找
    public User findByUser(String user){
        User ur=null;
        String sql="select * from user where user=?";
        try {
            ur = jt.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), user);
            return ur;
        }catch (Exception e) {
            e.printStackTrace();
            return ur;
        }
    }

    //更改用户
    public void updateUser(User ur){
        String sql="update user set password=?,balance=?,consumption=?,recharge=? where user=?";
        try {
            jt.update(sql,ur.getPassword(),ur.getBalance(),ur.getConsumption(),ur.getRecharge(),ur.getUser());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
