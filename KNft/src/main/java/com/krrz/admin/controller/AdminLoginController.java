package com.krrz.admin.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.core.Path;
import com.krrz.admin.validator.AdminLoginValidator;
import com.krrz.common.model.User;
import com.krrz.common.service.UserService;

import java.util.List;

@Path("/admin")
public class AdminLoginController extends Controller {
    private static UserService userService=new UserService();
    public void index(){
        render("login.html");
    }
    @Before(AdminLoginValidator.class)// Before注解用来对拦截器进行配置，该注解可配置Class、Method级别的拦截器
    public void login(){
        //接收登录参数
        String uname=getPara("uname");
        String pwd=getPara("pwd");
        //判断是否正确
        List<User> users =User.dao.find("select * from user where role=1 and uname = '"+uname+"' and pwd = '"+pwd+"' ");
        if (users.size()!=0){
            //登录成功
            setSessionAttr("currUser", users.get(0));
            redirect("/admin/collection/index");
        }else{
            //登录失败
            render("error.html");
        }
    }
}
