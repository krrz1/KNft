package com.krrz.nft.controller;

import com.jfinal.core.Controller;
import com.jfinal.core.Path;
import com.jfinal.json.FastJson;
import com.jfinal.plugin.activerecord.Page;
import com.krrz.common.model.Collection;
import com.krrz.common.model.User;
import com.krrz.common.model.base.ResponseResult;
import com.krrz.common.service.BillService;
import com.krrz.common.service.PossessionItemService;
import com.krrz.common.service.UserService;

import java.util.HashMap;

@Path("/possessionItem")
public class PossessionItemController extends Controller {
    private static UserService userService=new UserService();
    private static PossessionItemService possessionItemService=new PossessionItemService();
    private static BillService billService=new BillService();

    public void index(){
        //获取搜索关键词
        String keyword = getPara("keyword", "");
        User currUser = getSessionAttr("currUser");
        //分页展示
        int pageNumber=getParaToInt("pageNum",1);
        Page<Collection> collectionPage = possessionItemService.pageQuery(pageNumber,5,keyword,currUser.getId());
        //再找对应的count
        HashMap<Integer,Integer> map=possessionItemService.findCount(currUser.getId());
        //存在Attr中
        setAttr("countMap",map);
        setAttr("page",collectionPage);
        setAttr("keyword",keyword);
        render("index.html");
    }
    public void buy(){
        //获取参数
        String collectionId = getPara("collectionId");
        String userId = getPara("userId");
        double price = Double.parseDouble(getPara("price"));
        User currUser = getSessionAttr("currUser");
        //更新user表
        userService.editBalance(userId,currUser.getBalance()-price);
        //更新possessionItem表
        possessionItemService.updateAddOne(collectionId,userId);
        //更新bill表
        billService.add(price,userId);
        //更新当前session的currUser
        currUser.setBalance(currUser.getBalance()-price);
        setSessionAttr("currUser",currUser);
        //封装返回
        ResponseResult result=ResponseResult.okResult();
        renderJson(FastJson.getJson().toJson(result));
    }
    public void sell(){
        //接收参数
        String collectionId = getPara("collectionId");
        double price = Double.parseDouble(getPara("price"));
        //获取当前user
        User currUser = getSessionAttr("currUser");
        String userId= String.valueOf(currUser.getId());
        //user余额变多
        currUser.setBalance(currUser.getBalance()+price);
        setSessionAttr("currUser",currUser);
        //更新数据库
        //user表
        userService.editBalance(String.valueOf(currUser.getId()),currUser.getBalance()+price);
        //更新possessionItem表
        possessionItemService.delOne(collectionId,userId);
        index();
    }
}
