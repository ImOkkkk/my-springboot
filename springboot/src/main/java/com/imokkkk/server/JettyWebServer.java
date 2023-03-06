package com.imokkkk.server;

import org.springframework.web.context.WebApplicationContext;

/**
 * @author liuwy
 * @date 2023/3/6 10:06
 * @since 1.0
 */
public class JettyWebServer implements WebServer{

    @Override
    public void start(WebApplicationContext applicationContext) {
        System.out.println("启动jetty...");
    }
}
