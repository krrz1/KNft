package com.krrz.common.interceptor;


import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;

import java.util.logging.Logger;

public class GlobalActionInterceptor implements Interceptor {
    static Logger logger = Logger.getLogger("GlobalActionInterceptor");// 一般为当前的类名

    public void intercept(Invocation inv) {

        Controller controller = inv.getController();
        controller.getResponse().addHeader("Access-Control-Allow-Origin", "*");
        inv.invoke();
    }
}
