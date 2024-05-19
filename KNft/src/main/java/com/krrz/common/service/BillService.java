package com.krrz.common.service;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.krrz.common.model.Bill;

import java.util.Date;


public class BillService {
    private static Bill dao=new Bill().dao();
    public void add(double price, String userId) {
        //添加一条交易记录
        Date date=new Date();
        Record rd = new Record().set("user",userId).set("checkOutTime",date).set("totalMoney",price);
        Db.save("bill",rd);
    }

    public Page<Bill> pageQuery(int pageNumber, int i, Integer id) {
        Page<Bill> billPage = dao.paginate(pageNumber, 5, "select *", "from bill where user=? order by id desc",id);
        return billPage;
    }

    public void del(String billId) {
        Db.delete("delete from bill where id=?",billId);
    }
}
