package com.krrz.nft.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.core.Path;
import com.jfinal.json.FastJson;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.ehcache.CacheInterceptor;
import com.jfinal.plugin.ehcache.CacheName;
import com.jfinal.plugin.ehcache.EvictInterceptor;
import com.jfinal.upload.UploadFile;
import com.krrz.common.model.Collection;
import com.krrz.common.model.base.ResponseResult;
import com.krrz.common.service.CollectionService;

import java.util.List;

@Path("/collection")
public class CollectionController extends Controller {
    private static CollectionService collectionService=new CollectionService();
    @Before(CacheInterceptor.class)
    @CacheName("collectionList")
    public void index(){
        //查询所有藏品
        List<Collection> collections = collectionService.findAll();
        setAttr("collections",collections);
        render("index.html");
    }
    public void detail(){
        //获取参数
        String id = getPara("id");
        //从数据库查询藏品
        Collection collection=collectionService.findById(id);
        setAttr("collection",collection);
        //渲染页面
        render("collection_detail.html");
    }
    @Before(EvictInterceptor.class)
    @CacheName("collectionList")
    public void like(){
        //获取参数
        String collectionId = getPara("collectionId");
        int collectionLikeCount = Integer.parseInt(getPara("collectionLikeCount"));
        //更新数据库
        collectionService.updateLikeCount(collectionId,collectionLikeCount+1);
        //封装返回
        ResponseResult result=new ResponseResult(200,collectionLikeCount+1);
        renderJson(FastJson.getJson().toJson(result));
        return;
    }

}
