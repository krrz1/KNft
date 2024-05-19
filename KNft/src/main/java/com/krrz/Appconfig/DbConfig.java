package com.krrz.Appconfig;

import com.jfinal.ext.interceptor.SessionInViewInterceptor;
import com.jfinal.json.FastJsonFactory;
import com.krrz.common.model._MappingKit;

import com.jfinal.config.*;
import com.jfinal.template.Engine;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.plugin.ehcache.EhCachePlugin;
import com.jfinal.server.undertow.UndertowServer;
import com.krrz.common.route.AdminRoutes;
import com.krrz.common.route.FrontRoutes;

public class DbConfig extends JFinalConfig {

    /**
     * 注意：用于启动的 main 方法可以在任意 java 类中创建，在此仅为方便演示
     *      才将 main 方法放在了 DemoConfig 中
     *
     *      开发项目时，建议新建一个 App.java 或者 Start.java 这样的专用
     *      启动入口类放置用于启动的 main 方法
     */
    public static void main(String[] args) {
        UndertowServer.start(DbConfig.class, 8080, true);
    }

    public void configConstant(Constants me) {
       me.setDevMode(true);
       me.setInjectDependency(true);
       // 配置对超类中的属性进行注入
       me.setInjectSuperClass(true);
       //配置fastJson
        me.setJsonFactory(new FastJsonFactory());
        //文件上传路径
        me.setBaseUploadPath("D:\\IDEAworkspace\\KNft\\src\\main\\webapp\\static\\upload");
    }

    public void configRoute(Routes me) {
       // 使用路由扫描，参数 "demo." 表示只扫描 demo 包及其子包下的路由
    	me.scan("com.krrz.common.config.");
    	me.scan("com.krrz.common.model.");
    	me.scan("com.krrz.common.service");

        //前后台路由
        me.add(new FrontRoutes());
        me.add(new AdminRoutes());
    }

    public void configEngine(Engine me) {//Template Engine
    	me.setDevMode(true);
    }
    public void configPlugin(Plugins me) {
    	String jdbcUrlString="jdbc:mysql://localhost:3306/k_nft?serverTimezone=Asia/Shanghai&useSSL=false ";// 数据库连接
    	DruidPlugin druidPlugin=new DruidPlugin(jdbcUrlString, "root", "密码");  //数据库连接插件
    	ActiveRecordPlugin activeRecordPlugin=new ActiveRecordPlugin(druidPlugin);//模型插件
    	activeRecordPlugin.setDevMode(true);
    	activeRecordPlugin.setShowSql(true);
    	_MappingKit.mapping(activeRecordPlugin);
    	//添加插件
    	me.add(druidPlugin);
    	me.add(activeRecordPlugin);
    	me.add(new EhCachePlugin());
    }
    public void configInterceptor(Interceptors me) {
//        me.add(new GlobalActionInterceptor());
        me.add(new SessionInViewInterceptor());
    }
    public void configHandler(Handlers me) {}

}
