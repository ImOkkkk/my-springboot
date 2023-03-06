package com.imokkkk.server;

import org.springframework.web.context.WebApplicationContext;

/**
 * @author liuwy
 * @date 2023/3/6 9:36
 * @since 1.0
 */
public interface WebServer {

    void start(WebApplicationContext applicationContext);
}
