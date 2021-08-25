package cn.chaseshu.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

import java.util.Map;

public class OnSystemPropertyCondition implements Condition {
    
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
    
        Map<String, Object> attributes  = metadata.getAnnotationAttributes(
                ConditionalOnSystemProperty.class.getName());
        System.out.println("attributes : "  + attributes);
        
        String propertyName = String.valueOf(attributes.get("name"));
        System.out.println(propertyName);
    
        String propertyValue = String.valueOf(attributes.get("value"));
    
        String javaPropertyValue = System.getProperty(propertyName);
        System.out.println(System.getProperty("user.name"));
        System.out.println("javaPropertyValue : " + javaPropertyValue);
    
        return propertyValue.equals(javaPropertyValue);
    }
}
