package com.krrz.common.service;

import com.jfinal.plugin.activerecord.Db;
import com.krrz.common.model.User;

import java.util.List;

public class UserService {
    private static User dao=new User().dao();
    public void editBalance(String userId,double newBalance) {
        Db.update("update user set balance=? where id=?",newBalance,userId);
    }

    public List<Object> findByName(String uname) {
        return Db.query("select * from user where uname = ?", uname);
    }

    public void recharge(String userId, double v) {
        Db.update("update user set balance = ? where id = ?",v,userId);
    }
}
