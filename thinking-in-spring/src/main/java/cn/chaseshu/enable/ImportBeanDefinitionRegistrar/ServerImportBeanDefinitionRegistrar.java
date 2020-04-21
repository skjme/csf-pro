package cn.chaseshu.enable.ImportBeanDefinitionRegistrar;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.stream.Stream;

public class ServerImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        ServerImportSelector2 selector = new ServerImportSelector2();
        String[] classNames = selector.selectImports(importingClassMetadata);
        Stream.of(classNames).map(BeanDefinitionBuilder::genericBeanDefinition)
                .map(BeanDefinitionBuilder::getBeanDefinition)
                .forEach(definition -> BeanDefinitionReaderUtils.registerWithGeneratedName(definition, registry));
    }
}
