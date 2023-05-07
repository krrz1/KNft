package com.krrz.nft.controller;

import com.jfinal.core.Controller;
import com.jfinal.core.Path;
import com.jfinal.json.FastJson;
import com.krrz.common.model.User;
import com.krrz.common.model.base.ResponseResult;
import com.krrz.common.service.UserService;

@Path("/user")
public class UserController extends Controller {
    private static UserService userService=new UserService();
    public void recharge(){
        //获取参数
        String userId = getPara("userId");
        double userBalance = Double.parseDouble(getPara("userBalance"));
        double addNumber = Double.parseDouble(getPara("addNumber"));
        //更新session的currUser
        User currUser = getSessionAttr("currUser");
        currUser.setBalance(userBalance+addNumber);
        //更新数据库
        userService.recharge(userId,userBalance+addNumber);
        //封装返回
        ResponseResult result=new ResponseResult(200,userBalance+addNumber);
        renderJson(FastJson.getJson().toJson(result));
        return;
    }
}
