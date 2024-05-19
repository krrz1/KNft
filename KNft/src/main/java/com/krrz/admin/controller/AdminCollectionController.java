package com.krrz.admin.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.core.Path;
import com.jfinal.json.FastJson;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.ehcache.CacheName;
import com.jfinal.plugin.ehcache.EvictInterceptor;
import com.jfinal.upload.UploadFile;
import com.krrz.common.model.Collection;
import com.krrz.common.model.base.ResponseResult;
import com.krrz.common.service.CollectionService;

@Path("/admin/collection")
public class AdminCollectionController extends Controller {
    private static CollectionService collectionService=new CollectionService();
    //系统后台藏品管理
    public void index(){
        //获取搜索关键词
        String keyword = getPara("keyword", "");
        //分页展示
        int pageNumber=getParaToInt("pageNum",1);
        Page<Collection> collectionPage = collectionService.pageQuery(pageNumber,5,keyword);
        //存在Attr中
        setAttr("page",collectionPage);
        setAttr("keyword",keyword);
        render("collection.html");
    }
    @Before(EvictInterceptor.class)
    @CacheName("collectionList")
    public void add(){
        //获取参数
        UploadFile collectionImg = getFile("collectionImg");
        String collectionName = getPara("collectionName");
        double price = Double.parseDouble(getPara("price"));
        String sellers = getPara("sellers");
        //进行数据库更新
        collectionService.addCollection(collectionImg.getFileName(),collectionName,price,sellers);
        //刷新页面
        redirect("/admin/collection");
    }
    @Before(EvictInterceptor.class)
    @CacheName("collectionList")
    public void edit(){
        //获取参数
        UploadFile collectionImg = getFile("collectionImg");
        String collectionName = getPara("collectionName");
        double price = Double.parseDouble(getPara("price"));
        String sellers = getPara("sellers");
        String likeCount=getPara("likeCount");
        String id=getPara("id");
        //进行数据库更新
        collectionService.editCollection(id,collectionImg.getFileName(),collectionName,price,sellers,likeCount);
        //刷新页面
        redirect("/admin/collection");
    }
    @Before(EvictInterceptor.class)
    @CacheName("collectionList")
    public void del(){
        //获取参数
        String id = getPara("id");
        //数据更新
        collectionService.delCollection(id);
        //刷新页面
        redirect("/admin/collection");
    }
    public void editPage(){
        //获取参数id,collectionName,price,sellers
        String id = getPara("id");
        String collectionName = getPara("collectionName");
        String price = getPara("price");
        String sellers = getPara("sellers");
        String likeCount = getPara("likeCount");
        //设置attr
        setAttr("id",id);
        setAttr("collectionName",collectionName);
        setAttr("price",price);
        setAttr("sellers",sellers);
        setAttr("likeCount",likeCount);

        //渲染页面
        render("collection_edit.html");
    }

}
