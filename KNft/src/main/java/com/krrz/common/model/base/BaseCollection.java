package com.krrz.common.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseCollection<M extends BaseCollection<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Integer id) {
		set("id", id);
	}
	
	public java.lang.Integer getId() {
		return getInt("id");
	}
	
	public void setCollectionImg(java.lang.String collectionImg) {
		set("collectionImg", collectionImg);
	}
	
	public java.lang.String getCollectionImg() {
		return getStr("collectionImg");
	}
	
	public void setCollectionName(java.lang.String collectionName) {
		set("collectionName", collectionName);
	}
	
	public java.lang.String getCollectionName() {
		return getStr("collectionName");
	}
	
	public void setPrice(java.lang.Double price) {
		set("price", price);
	}
	
	public java.lang.Double getPrice() {
		return getDouble("price");
	}
	
	public void setSellers(java.lang.String sellers) {
		set("sellers", sellers);
	}
	
	public java.lang.String getSellers() {
		return getStr("sellers");
	}
	
	public void setStatus(java.lang.Integer status) {
		set("status", status);
	}
	
	public java.lang.Integer getStatus() {
		return getInt("status");
	}
	
	public void setLikeCount(java.lang.Integer likeCount) {
		set("likeCount", likeCount);
	}
	
	public java.lang.Integer getLikeCount() {
		return getInt("likeCount");
	}
	
}
