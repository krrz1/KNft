package com.krrz.common.service;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.krrz.common.model.Collection;
import com.krrz.common.model.PossessionItem;

import java.util.HashMap;
import java.util.List;

public class PossessionItemService {
    private static PossessionItem dao=new PossessionItem().dao();
    private static Collection collectionDao=new Collection().dao();
    public void updateAddOne(String collectionId, String userId) {
        //判断用户是否已经拥有一个
        List<PossessionItem> possessionItems = dao.find("select * from possession_item where collection=? and user=?", collectionId, userId);
        if(possessionItems.isEmpty()){
            //如果没有新建一条记录
            Record rd = new Record().set("collection",collectionId).set("user",userId);
            Db.save("possession_item",rd);
        }else{
            //如果有了就count+1
            Db.update("update possession_item set count =count+1 where collection=? and user=?",collectionId,userId);
        }
    }

    public Page<Collection> pageQuery(int pageNumber, int i, String keyword,int userId) {
        Page<Collection> collectionPage = collectionDao.paginate(pageNumber, 5, "select c.*", "from collection c right join (SELECT * from possession_item where user=?) p on c.id=p.collection where collectionName like ?",userId,"%"+keyword+"%");
        return collectionPage;
    }

    public HashMap<Integer, Integer> findCount(Integer id) {
        //找到当前用户所有的对应
        List<PossessionItem> possessionItems = dao.find("select * from possession_item where user=?",id);
        HashMap<Integer,Integer> map=new HashMap<>();
        for(PossessionItem possessionItem:possessionItems){
            map.put(possessionItem.getCollection(),possessionItem.getCount());
        }
        return map;
    }

    public void delOne(String collectionId, String userId) {
        //判断用户是否只拥有一个
        List<PossessionItem> possessionItems = dao.find("select * from possession_item where collection=? and user=?", collectionId, userId);
        if(possessionItems.get(0).getCount()==1){
            //整条删除
            Db.delete("delete from possession_item where collection = ? and user = ?",collectionId,userId);
        }else{
            //否则count-1
            Db.update("update possession_item set count =count-1 where collection=? and user=?",collectionId,userId);
        }
    }
}
