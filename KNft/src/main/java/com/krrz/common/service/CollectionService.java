package com.krrz.common.service;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.krrz.common.model.Collection;

import java.util.List;

public class CollectionService {
    private static Collection dao=new Collection().dao();

    public Page<Collection> pageQuery(int pageNumber, int i,String keyword) {
        Page<Collection> collectionPage = dao.paginate(pageNumber, 5, "select *", "from collection where collectionName like ?","%"+keyword+"%");
        return collectionPage;
    }

    public void addCollection(String collectionImg, String collectionName, double price, String sellers) {
        Record rd = new Record().set("collectionImg",collectionImg).set("collectionName",collectionName).set("price",price).set("sellers",sellers);
        Db.save("collection",rd);
    }

    public void editCollection(String id, String collectionImg, String collectionName, double price, String sellers, String likeCount) {
        Db.update("update collection set collectionImg=? , collectionName=?, price=?, sellers=? , likeCount=? where id=?",collectionImg,collectionName,price,sellers,likeCount,id);
    }

    public void delCollection(String id) {
        Db.delete("delete from collection where id=?",id);
        //删除用户个人仓库里面的关联相
        Db.delete("delete from possession_item where collection=?",id);
    }

    public List<Collection> findAll() {
        List<Collection> collections = dao.findAll();
        return collections;
    }

    public Collection findById(String id) {
        return dao.findById(id);
    }

    public void updateLikeCount(String collectionId, int collectionLikeCount) {
        Db.update("update collection set likeCount = ? where id = ?",collectionLikeCount,collectionId);
    }
}
