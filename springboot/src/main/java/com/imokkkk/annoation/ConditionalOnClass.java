package com.imokkkk.annoation;

import com.imokkkk.helper.OnClassCondition;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Conditional;

/**
 * @author liuwy
 * @date 2023/3/6 10:00
 * @since 1.0
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Conditional(OnClassCondition.class)
public @interface ConditionalOnClass {
    String value() default "";
}
