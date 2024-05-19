package com.krrz.nft.validator;

import com.jfinal.core.Controller;
import com.jfinal.json.FastJson;
import com.jfinal.validate.Validator;
import com.krrz.common.model.base.ResponseResult;
import com.krrz.common.service.UserService;
import com.krrz.common.utils.AppHttpCodeEnum;

public class RegisterValidator extends Validator {


    @Override
    protected void validate(Controller controller) {
        setShortCircuit(true);
        validateRequiredString("uname","unameMsg","请输入名称");
        //用户名是否存在
        if(!new UserService().findByName(controller.getPara("uname")).isEmpty()){
            addError("unameIsExist","用户名已存在");
        }
        validateRequiredString("pwd","pwdMsg","密码不为空");
        validateRequiredString("email","emailMsg","密码不为空");
        if(!controller.getPara("email").matches("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$")){
            addError("emailError","邮箱地址不对");
        }
    }

    @Override
    protected void handleError(Controller controller) {
        ResponseResult result;
        if(controller.getAttr("unameMsg")!=null){
            result=new ResponseResult<>(AppHttpCodeEnum.USERNAME_NOT_NULL.getCode(), AppHttpCodeEnum.USERNAME_NOT_NULL.getMsg());
        }else if(controller.getAttr("unameIsExist")!=null){
            result=new ResponseResult(AppHttpCodeEnum.USERNAME_EXIST.getCode(),AppHttpCodeEnum.USERNAME_EXIST.getMsg());
        }else if(controller.getAttr("pwdMsg")!=null){
            result=new ResponseResult(AppHttpCodeEnum.PASSWORD_NOT_NULL.getCode(),AppHttpCodeEnum.PASSWORD_NOT_NULL.getMsg());
        }else if(controller.getAttr("emailMsg")!=null){
            result=new ResponseResult(AppHttpCodeEnum.EMAILL_NOT_NULL.getCode(),AppHttpCodeEnum.EMAILL_NOT_NULL.getMsg());
        }else{
            result=new ResponseResult(AppHttpCodeEnum.EMAIL_ERROR.getCode(),AppHttpCodeEnum.EMAIL_ERROR.getMsg());
        }
        controller.renderJson(FastJson.getJson().toJson(result));
    }
}
