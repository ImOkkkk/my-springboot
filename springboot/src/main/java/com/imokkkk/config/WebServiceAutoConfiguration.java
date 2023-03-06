package com.imokkkk.config;

import com.imokkkk.annoation.ConditionalOnClass;
import com.imokkkk.server.JettyWebServer;
import com.imokkkk.server.TomcatWebServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liuwy
 * @date 2023/3/6 10:05
 * @since 1.0
 */

//SPI
@Configuration
public class WebServiceAutoConfiguration implements AutoConfiguration{

    //只有存在"org.apache.catalina.startup.Tomcat"类，那么才有TomcatWebServer这个Bean
    @Bean
    @ConditionalOnClass("org.apache.catalina.startup.Tomcat")
    public TomcatWebServer tomcatWebServer(){
        return new TomcatWebServer();
    }

    //只有存在"org.eclipse.jetty.server.Server"类，那么才有TomcatWebServer这个Bean
    @Bean
    @ConditionalOnClass("org.eclipse.jetty.server.Server")
    public JettyWebServer jettyWebServer(){
        return new JettyWebServer();
    }

}
