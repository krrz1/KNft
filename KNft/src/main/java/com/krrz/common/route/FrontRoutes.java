package com.krrz.common.route;

import com.jfinal.config.Routes;

public class FrontRoutes extends Routes {
    @Override
    public void config() {
        setBaseViewPath("/view/nft");
        this.scan("com.krrz.nft");
    }
}
