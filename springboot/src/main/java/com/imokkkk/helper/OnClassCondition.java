package com.imokkkk.helper;

import com.imokkkk.annoation.ConditionalOnClass;
import java.util.Map;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author liuwy
 * @date 2023/3/6 10:01
 * @since 1.0
 */
public class OnClassCondition implements Condition {

    // 拿到@ConditionalOnClass中的value属性，然后用类加载器进行加载，
    // 如果加载到了所指定的这个类，那就表示符合条件，如果加载不到，则表示不符合条件。
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> annotationAttributes =
                metadata.getAnnotationAttributes(ConditionalOnClass.class.getName());
        String className = (String) annotationAttributes.get("value");
        try {
            context.getClassLoader().loadClass(className);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}
