package com.krrz.nft.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.core.Path;
import com.jfinal.json.FastJson;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.krrz.common.model.User;
import com.krrz.common.model.base.ResponseResult;
import com.krrz.common.service.UserService;
import com.krrz.common.utils.AppHttpCodeEnum;
import com.krrz.nft.validator.LoginValidator;
import com.krrz.nft.validator.RegisterValidator;

import java.util.List;

@Path("/")
public class LoginController extends Controller {
    private static UserService userService=new UserService();
    public void index(){
        render("login.html");
    }
    @Before(LoginValidator.class)// Before注解用来对拦截器进行配置，该注解可配置Class、Method级别的拦截器
    public void login(){
        //接收登录参数
        String uname=getPara("uname");
        String pwd=getPara("pwd");
        //判断是否正确
        List<User> users =User.dao.find("select * from user where uname = '"+uname+"' and pwd = '"+pwd+"' ");
        if (users.size()!=0){
            //登录成功
            setSessionAttr("currUser", users.get(0));
            redirect("collection/index");
        }else{
            //登录失败
            render("error.html");
        }
    }
    @Before(RegisterValidator.class)
    public void register(){
        //接受注册参数
        String uname=getPara("uname");
        String pwd=getPara("pwd");
        String email=getPara("email");
        //注册成功 正常登录
        Record rd = new Record().set("uname",uname).set("pwd",pwd).set("email",email);
        Db.save("user",rd);
        ResponseResult result=new ResponseResult<>(AppHttpCodeEnum.SUCCESS.getCode(), AppHttpCodeEnum.SUCCESS.getMsg());
        renderJson(FastJson.getJson().toJson(result));
        return;
    }
    public void registerPage(){
        render("register.html");
    }
}
