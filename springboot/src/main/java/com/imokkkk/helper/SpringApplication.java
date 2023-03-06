package com.imokkkk.helper;

import com.imokkkk.server.WebServer;
import java.util.Map;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

/**
 * @author liuwy
 * @date 2023/3/6 9:30
 * @since 1.0
 */
public class SpringApplication {
    // 1. 创建一个AnnotationConfigWebApplicationContext容器
    // 2. 解析Application类，然后进行扫描
    // 3. SPI机制找到WebServiceAutoConfiguration这个配置类并添加到Spring容器中
    // 4. 通过getWebServer方法从Spring容器中获取WebServer类型的Bean
    // 5. 调用WebServer对象的start方法
    public static void run(Class clazz) {
        // Application是所创建出来的Spring容器的配置类，
        // 并且由于Application类上有@SpringBootApplication注解，而@SpringBootApplication注解的定义上又
        // 存在@ComponentScan注解，所以AnnotationConfigWebApplicationContext容器在执行refresh时，
        // 就会解析Application这个配置类，从而发现定义了@ComponentScan注解，也就知道了要进行扫描，
        // 只不过扫描路径为空，而AnnotationConfigWebApplicationContext容器会处理这种情况，如果扫描路径会空，
        // 则会将Application所在的包路径做为扫描路径，从而就会扫描到UserService和UserController。
        // 所以Spring容器创建完之后，容器内部就拥有了UserService和UserController这两个Bean。
        AnnotationConfigWebApplicationContext applicationContext =
                new AnnotationConfigWebApplicationContext();
        applicationContext.register(clazz);
        applicationContext.refresh();

        WebServer webServer = getWebServer(applicationContext);
        webServer.start(applicationContext);
    }

    public static WebServer getWebServer(WebApplicationContext applicationContext) {
        Map<String, WebServer> beansOfType = applicationContext.getBeansOfType(WebServer.class);
        if (beansOfType.isEmpty()) {
            throw new NullPointerException();
        }

        if (beansOfType.size() > 1) {
            throw new IllegalStateException();
        }

        return beansOfType.values().stream().findFirst().get();
    }
}
