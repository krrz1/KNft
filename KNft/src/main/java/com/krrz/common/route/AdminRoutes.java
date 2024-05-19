package com.krrz.common.route;

import com.jfinal.config.Routes;

public class AdminRoutes extends Routes {

    @Override
    public void config() {
        setBaseViewPath("/view");
        this.scan("com.krrz.admin");
    }
}
