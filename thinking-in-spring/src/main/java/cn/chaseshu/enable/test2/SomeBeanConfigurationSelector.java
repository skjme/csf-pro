package cn.chaseshu.enable.test2;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

// 带Selector的Enable注解
// 当然，Enable注解可以更加复杂，可以根据所在上下文来激活不同类型的bean。
// 比如：EnableCaching，可以根据类路径上的不同实现来激活对应的缓存。
public class SomeBeanConfigurationSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        AnnotationAttributes attributes = AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes(EnableSomeBeansSelector.class.getName(), false));
        String criteria = attributes.getString("criteria");
        if (criteria.equals("default")) {
            return new String[]{"cn.chaseshu.enable.test2.SomeBeanConfigurationDefault"};
        }else {
            return new String[]{"cn.chaseshu.enable.test2.SomeBeanConfigurationType1"};
        }

    }
}
