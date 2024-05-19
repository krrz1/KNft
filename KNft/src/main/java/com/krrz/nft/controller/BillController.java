package com.krrz.nft.controller;

import com.jfinal.core.Controller;
import com.jfinal.core.Path;
import com.jfinal.plugin.activerecord.Page;
import com.krrz.common.model.Bill;
import com.krrz.common.model.User;
import com.krrz.common.service.BillService;

@Path("bill")
public class BillController extends Controller {
    private static BillService billService=new BillService();
    public void index(){
        //分页展示
        int pageNumber=getParaToInt("pageNum",1);
        User currUser = getSessionAttr("currUser");
        Page<Bill> billPage = billService.pageQuery(pageNumber,5,currUser.getId());
        //存在Attr中
        setAttr("page",billPage);
        render("index.html");
    }
    public void del(){
        //获取参数
        String billId = getPara("billId");
        billService.del(billId);
        index();
    }
}
