package com.imokkkk.annoation;

import com.imokkkk.helper.ImportSelect;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author liuwy
 * @date 2023/3/6 9:25
 * @since 1.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration
@ComponentScan
//利用spring中的@Import技术来导入这些配置类
@Import(ImportSelect.class)
public @interface SpringBootApplication {}
