package com.krrz.common.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseUser<M extends BaseUser<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Integer id) {
		set("id", id);
	}
	
	public java.lang.Integer getId() {
		return getInt("id");
	}
	
	public void setUname(java.lang.String uname) {
		set("uname", uname);
	}
	
	public java.lang.String getUname() {
		return getStr("uname");
	}
	
	public void setPwd(java.lang.String pwd) {
		set("pwd", pwd);
	}
	
	public java.lang.String getPwd() {
		return getStr("pwd");
	}
	
	public void setEmail(java.lang.String email) {
		set("email", email);
	}
	
	public java.lang.String getEmail() {
		return getStr("email");
	}
	
	public void setRole(java.lang.Integer role) {
		set("role", role);
	}
	
	public java.lang.Integer getRole() {
		return getInt("role");
	}
	
	public void setBalance(java.lang.Double balance) {
		set("balance", balance);
	}
	
	public java.lang.Double getBalance() {
		return getDouble("balance");
	}
	
}

