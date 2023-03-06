package com.imokkkk.helper;

import com.imokkkk.config.AutoConfiguration;
import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author liuwy
 * @date 2023/3/6 10:14
 * @since 1.0
 */
public class ImportSelect implements DeferredImportSelector {

    // 从com.imokkkk.config.AutoConfiguration文件中获取自动配置类的名字，并导入到Spring容器中
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        ServiceLoader<AutoConfiguration> serviceLoader =
                ServiceLoader.load(AutoConfiguration.class);
        List<String> list = new ArrayList<>();
        for (AutoConfiguration autoConfiguration : serviceLoader) {
            list.add(autoConfiguration.getClass().getName());
        }
        return list.toArray(new String[0]);
    }
}
