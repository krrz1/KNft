package com.krrz.nft.validator;

import com.jfinal.core.Controller;
import com.jfinal.kit.Ret;
import com.jfinal.validate.Validator;

public class LoginValidator extends Validator {

	@Override
	protected void validate(Controller c) {
		// 校验逻辑
		setShortCircuit(true);  //快捷验证    ||  &&
		//validateRequired("name", "msg", "姓名不能为空");
		validateRequiredString("uname","unameMsg","请输入名称");
		c.setAttr("uname",c.getPara("uname"));
		validateRequiredString("pwd","pwdMsg","请输入密码");

		//validateEmail(field, errorKey, errorMessage);
		//System.out.println("in vali");

	}

	@Override
	protected void handleError(Controller c) {
		//检验失败的时候 如何处理
//		c.keepPara("uname");
//		c.keepPara("pwd");
//		c.set("msg", c.getAttr("msg"));
		c.render("login.html");
	}

}
